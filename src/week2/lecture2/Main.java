package week2.lecture2;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        JFrame frame = new JFrame("Hello World");
        frame.getContentPane().add(helloWorld);
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
