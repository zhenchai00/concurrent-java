package week7.lecture7.DiningNetbeans;

import java.awt.*;
import java.awt.geom.AffineTransform;

class PhilCanvas extends Canvas {

    Diners controller;

    static final int NUMPHILS = 5;
    static final int THINKING = 0;
    static final int HUNGRY = 1;
    static final int GOTRIGHT = 2;
    static final int EATING = 3;
    static final int GOTLEFT = 4;

    Image[] imgs = new Image[5];

    AffineTransform[] philPlace = new AffineTransform[NUMPHILS];

    int[] state = new int[NUMPHILS];

    double[] chopX = new double[NUMPHILS];
    double[] chopY = new double[NUMPHILS];
    boolean[] untable = new boolean[NUMPHILS];

    boolean frozen = false;

    PhilCanvas(Diners controller) {
        super();
        this.controller = controller;

        MediaTracker mt;
        mt = new MediaTracker(this);

        imgs[0] = controller.getImage(controller.getDocumentBase(), "classes/image/thinking.gif");
        mt.addImage(imgs[0], 0);
        imgs[1] = controller.getImage(controller.getDocumentBase(), "classes/image/hungry.gif");
        mt.addImage(imgs[1], 1);
        imgs[2] = controller.getImage(controller.getDocumentBase(), "classes/image/gotright.gif");
        mt.addImage(imgs[2], 2);
        imgs[3] = controller.getImage(controller.getDocumentBase(), "classes/image/eating.gif");
        mt.addImage(imgs[3], 3);
        imgs[4] = controller.getImage(controller.getDocumentBase(), "classes/image/gotleft.gif");
        mt.addImage(imgs[4], 4);

        try {
            mt.waitForID(0);
            mt.waitForID(1);
            mt.waitForID(2);
            mt.waitForID(3);
            mt.waitForID(4);
        } catch (java.lang.InterruptedException e) {
            System.out.println("Couldn't load one of the images");
        }
        initPlacing();
    }

    Image offscreen;
    Dimension offscreensize;
    Graphics offgraphics;

    void backdrop() {
        Dimension d = getSize();
        if ((offscreen == null) || (d.width != offscreensize.width)
                || (d.height != offscreensize.height)) {
            offscreen = createImage(d.width, d.height);
            offscreensize = d;
            offgraphics = offscreen.getGraphics();
            offgraphics.setFont(new Font("Helvetica", Font.BOLD, 18));
            Graphics2D g2D = (Graphics2D) offgraphics;
            g2D.translate(d.width / 2, d.height / 2); // set origin to centre
        }
        offgraphics.setColor(Color.lightGray);
        offgraphics.fillRect(-d.width / 2, -d.height / 2, d.width, d.height);
    }

    void drawtable() {
        offgraphics.setColor(Color.red);
        offgraphics.fillOval(-45, -45, 90, 90);
        offgraphics.setColor(Color.black);
        for (int i = 0; i < NUMPHILS; i++) {
            if (untable[i])
                offgraphics.fillOval((int) chopX[i], (int) chopY[i], 10, 10);
            // offgraphics.drawString(String.valueOf(i),(int)chopX[i],(int)chopY[i]);
        }
    }

    public void paint(Graphics g) {
        update(g);
    }

    public void update(Graphics g) {
        backdrop();
        for (int i = 0; i < NUMPHILS; i++) {
            philPaint(offgraphics, i);
        }
        drawtable();
        if (deadlocked()) {
            offgraphics.setColor(Color.black);
            offgraphics.drawString("DEADLOCKED", -60, 0);
        }
        g.drawImage(offscreen, 0, 0, null);
    }

    void philPaint(Graphics g, int i) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(imgs[state[i]], philPlace[i], this);
    }

    synchronized void setPhil(int id, int s) throws java.lang.InterruptedException {
        while (frozen)
            wait();
        state[id] = s;
        repaint();
    }

    synchronized void freeze() {
        frozen = true;
    }

    synchronized void thaw() {
        frozen = false;
        notifyAll();
    }

    synchronized void setFork(int id, boolean taken) {
        untable[id] = !taken;
    }

    boolean deadlocked() {
        int i = 0;
        while (i < NUMPHILS && state[i] == GOTRIGHT)
            ++i;
        return i == NUMPHILS;
    }

    void initPlacing() {

        double radius = 100.0;
        double philWidth = imgs[0].getWidth(this);
        double philHeight = imgs[0].getHeight(this);
        double radians;

        for (int i = 0; i < NUMPHILS; i++) {
            philPlace[i] = new AffineTransform();
            radians = 2.0 * Math.PI * (1.0 - (double) i / (double) NUMPHILS);
            philPlace[i].rotate(radians);
            philPlace[i].translate(0, -radius);
            philPlace[i].translate(-philWidth / 2, -philHeight / 2);
        }

        radius = 35;
        for (int i = 0; i < NUMPHILS; i++) {
            radians = (double) i * 2.0 * Math.PI / (double) NUMPHILS + Math.PI / (double) NUMPHILS;
            chopX[i] = -Math.sin(radians) * radius - 5;
            chopY[i] = -Math.cos(radians) * radius - 5;
            untable[i] = true;
        }
    }
}
