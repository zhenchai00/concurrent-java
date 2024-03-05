package week2.lecture2;

import java.applet.Applet;
import java.awt.Graphics;

public class HelloWorld extends Applet {
    public HelloWorld() {
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("Hello World!", 20, 20);
    }
}
