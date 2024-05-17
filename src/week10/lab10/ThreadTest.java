package week10.lab10;

public class ThreadTest {
    public static void main(String[] args) {
        Bomb b1 = new Bomb("Bomb 1", 2500);
        Bomb b2 = new Bomb("Bomb 2", 1000);
        Bomb b3 = new Bomb("Bomb 3", 50);
        b1.start();
        b2.run(); // still part of the main thread
        new Thread(b3).start();
    }
}
