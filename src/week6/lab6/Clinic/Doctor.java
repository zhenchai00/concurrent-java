package week6.lab6.Clinic;

import java.util.Random;

public class Doctor {

    synchronized void visit(Patients use) { // the synchronized is to lock the method only one thread using it
        System.out.println(use.id + " Visit Doc ");
        try {
            Thread.sleep(new Random().nextInt(5) * 1000);
        } catch (Exception e) {
        }
        System.out.println(use.id + " left ");
    }
}