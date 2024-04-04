package week6.lab6.InPatient;

import java.util.Random;
import java.util.concurrent.TimeUnit;
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
        try {
            if (lock.tryLock(new Random().nextInt(15), TimeUnit.SECONDS)) {
                doc.visit(this);
                lock.unlock();
            } else {
                System.out.println("Patient " + id + " is tired of waiting. Bye!");
            }
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
