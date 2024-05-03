package week9.lab9.BlockingQueueExample;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    protected BlockingQueue<String> queue = null;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    // public void run() {
    //     try {
    //         System.out.println("Put Queue size: " + queue.size());

    //         queue.put("1");
    //         System.out.println("Put 1");
    //         System.out.println("Put Queue size: " + queue.size());
    //         Thread.sleep(1000);

    //         queue.put("2");
    //         System.out.println("Put 2");
    //         System.out.println("Put Queue size: " + queue.size());

    //         queue.put("3");// waiting
    //         System.out.println("Put 3");
    //         System.out.println("Put Queue size: " + queue.size());
    //         queue.put("4");// waiting
    //         System.out.println("Put 4");
    //         System.out.println("Put Queue size: " + queue.size());
    //         queue.put("5");// waiting
    //         System.out.println("Put 5");
    //         System.out.println("Put Queue size: " + queue.size());
    //         queue.put("6");// waiting
    //         System.out.println("Put 6");
    //         System.out.println("Put Queue size: " + queue.size());
    //     } catch (InterruptedException e) {
    //         e.printStackTrace();
    //     }
    // }

    public void run() {
        try {
            System.out.println("Put Queue size: " + queue.size());
            queue.offer("1");
            System.out.println("Put 1");
            System.out.println("Put Queue size: " + queue.size());
            Thread.sleep(1000);

            queue.offer("2");
            System.out.println("Put 2");
            System.out.println("Put Queue size: " + queue.size());

            if (!queue.offer("3")) {// no waiting. Leave if unsuccessful
                System.out.println("No space! I'm leaving..");
                return;
            } else {
                System.out.println("Put 3");
                System.out.println("Put Queue size: " + queue.size());
            }
            ;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}