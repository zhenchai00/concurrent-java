package week7.lab7.Barber2024;

public class Clock extends Thread {

    private CustomerGenerator cg;
    private Barber b;

    public Clock(CustomerGenerator cg, Barber b) {
        this.cg = cg;
        this.b = b;
    }

    public void run() {
        try {
            Thread.sleep(15000);
            NotifyClosed();
            cg.setClosingTime();
            b.setClosingTime();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public synchronized void NotifyClosed() {
        System.out.println("Clock: Barber Shop IS CLOSED! THANK YOU");
        cg.closingTime = true;
        b.closingTime = true;
    }
}
