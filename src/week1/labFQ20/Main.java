package week1.labFQ20;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
    public static JFrame frame;
    public static JPanel panel;
    public static JLabel label;
    public static void main(String[] args) {
        frame = new JFrame("Rectangles");
        frame.setSize(500, 400);
        frame.setLocation(1000,200);
        frame.setVisible(true);

        label = new JLabel("I Love !");

        panel = new JPanel();
        panel.setBackground(java.awt.Color.GREEN);
        panel.setSize(200, 200);
        panel.add(label);
        frame.add(panel);
    }
}
