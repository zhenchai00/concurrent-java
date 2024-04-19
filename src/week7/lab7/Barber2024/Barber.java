package week7.lab7.Barber2024;

class Barber implements Runnable {
    Bshop shop;
    public boolean closingTime = false;

    public Barber(Bshop shop) {
        this.shop = shop;
    }

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException iex) {
            iex.printStackTrace();
        }
        System.out.println("Barber started..");
        while (!closingTime) {
            shop.cutHair();
        }
        if (closingTime) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return;
        }
    }

    public synchronized void setClosingTime() {
        this.closingTime = true;
        System.out.println("Barber: We're closing now!");
    }
}