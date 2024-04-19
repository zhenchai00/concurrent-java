package week7.lab7.Barber2024;

public class Clock extends Thread {
    private CustomerGenerator cg;
    private Barber barber;

    Clock (CustomerGenerator cg, Barber barber) {
        this.cg = cg;
        this.barber = barber;
    }

    public void run() {
        try {
            Thread.sleep(15000);
            System.out.println("Clock: Tick Tock... It's closing time!");
            cg.setClosingTime();
            barber.setClosingTime();
            // cg.closingTime = true;
            // barber.closingTime = true;
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
