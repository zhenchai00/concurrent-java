package week10.lab10;

import java.util.concurrent.locks.Lock;

public class User extends Thread{
    Laptop L;
    Lock lock;
    String name;

    public User(String name, Laptop lt, Lock lock) {
        this.setName(name);
        this.L = lt;
        this.lock = lock;
    }

    public void run() {
        lock.lock();
        L.take(this);
        System.out.println(this.getName() + " is using the laptop");
        L.put(this);
        lock.unlock();
    }
}
