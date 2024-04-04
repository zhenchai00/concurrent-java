package week6.lab6.InPatient;

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
        Patients u5 = new Patients(5, doc, lock);
        Patients u6 = new Patients(6, doc, lock);
        Patients u7 = new Patients(7, doc, lock);
        Patients u8 = new Patients(8, doc, lock);
        Patients u9 = new Patients(9, doc, lock);

        u1.start();
        u2.start();
        u3.start();
        u4.start();
        u5.start();
        u6.start();
        u7.start();
        u8.start();
        u9.start();
    }
}
