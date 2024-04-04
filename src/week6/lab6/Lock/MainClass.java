package week6.lab6.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    public static void main(String ar[]) {
        Lock lock = new ReentrantLock();
        Doctor doc = new Doctor();
        Patients u1 = new Patients(1, doc, lock);
        Patients u2 = new Patients(2, doc, lock);
        Patients u3 = new Patients(3, doc, lock);
        Patients u4 = new Patients(4, doc, lock);

        u1.start();
        u2.start();
        u3.start();
        u4.start();
    }
}
