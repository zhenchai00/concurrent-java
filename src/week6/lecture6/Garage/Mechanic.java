package week6.lecture6.Garage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Mechanic extends Thread {

    String threadName;
    Car car;

    Mechanic(String name, Car car) {
        threadName = name;
        this.car = car;

        System.out.println("** " + threadName + " reporting for work! **");
    }

    public void run() {

        try {
            car.serviceCar(this);
            System.out.println("-- " + threadName + " engine repairs on " + car.carName + " done! --");
        } catch (InterruptedException ex) {
            Logger.getLogger(Mechanic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
