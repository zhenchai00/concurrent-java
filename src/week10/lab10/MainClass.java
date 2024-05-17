package week10.lab10;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    static Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        User sally = User("Salley", laptop, lock);
        User ahmad = User("Ahmad", laptop, lock);
        sally.run();
        ahmad.run();
    }
}
