package week6.lab6.Distribute;

import java.util.concurrent.locks.Lock;

public class Patients extends Thread {
    Doctor doc;
    int id;
    Lock lock;

    public Patients(int id, Doctor dr, Lock lock) {
        this.id = id;
        doc = dr;
        this.lock = lock;
    }

    public void run() {
        lock.lock();
        doc.visit(this);
        lock.unlock();
    }
}
