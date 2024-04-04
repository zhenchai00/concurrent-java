package week6.lab6.Lock;

import java.util.Random;

public class Doctor {

    void visit(Patients use) {
        System.out.println(use.id + " Visit Doc ");
        try {
            Thread.sleep(new Random().nextInt(5) * 1000);
        } catch (Exception e) {
        }
        System.out.println(use.id + " left ");
    }
}