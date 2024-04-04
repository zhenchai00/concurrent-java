package week6.lab6.Distribute;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    public static void main(String ar[]) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        Doctor doc1 = new Doctor("Chong");
        Doctor doc2 = new Doctor("Sally");
        Patients u1 = new Patients(1, doc1, lock1);
        Patients u2 = new Patients(2, doc2, lock2);
        Patients u3 = new Patients(3, doc1, lock1);
        Patients u4 = new Patients(4, doc2, lock2);
        Patients u5 = new Patients(5, doc1, lock1);
        Patients u6 = new Patients(6, doc2, lock2);

        u1.start();
        u2.start();
        u3.start();
        u4.start();
        u5.start();
        u6.start();
    }
}
