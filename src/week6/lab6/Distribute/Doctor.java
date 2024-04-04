package week6.lab6.Distribute;

import java.util.Random;

public class Doctor {
    private String name;

    Doctor(String name) {
        this.name = name;
    }

    void visit(Patients use) {
        System.out.println("Patient " + use.id + " Visit Doc " + name);
        try {
            Thread.sleep(new Random().nextInt(5) * 1000);
        } catch (Exception e) {
        }
        System.out.println("Patient " + use.id + " left ");
    }
}