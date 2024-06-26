package week7.lab7.Barber2024;

import java.util.Date;
import java.util.concurrent.TimeUnit;

class CustomerGenerator implements Runnable {
    Bshop shop;
    public boolean closingTime = false;

    public CustomerGenerator(Bshop shop) {
        this.shop = shop;
    }

    public void run() {
        while (!closingTime) {
            Customer customer = new Customer(shop);
            customer.setInTime(new Date());
            Thread thcustomer = new Thread(customer);
            customer.setName("Customer " + thcustomer.getId());
            thcustomer.start();

            try {
                TimeUnit.SECONDS.sleep((long) (Math.random() * 50));
            } catch (InterruptedException iex) {
                iex.printStackTrace();
            }
        }
        if (closingTime) {
            try {
                Thread.sleep(1000);
                // check if there are no customers in the shop, barber waits for 1 more customer to come in
                if (shop.listCustomer.size() == 0) {
                    System.out.println("Looks like it's been a slow day, let's wait for one more customer");
                    Customer customer = new Customer(shop);
                    customer.setInTime(new Date());
                    Thread thcustomer = new Thread(customer);
                    customer.setName("Customer " + thcustomer.getId());
                    thcustomer.start();
                }

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return;
        }
    }

    public synchronized void setClosingTime() {
        this.closingTime = true;
        System.out.println("No more customers for today!");
    }

}