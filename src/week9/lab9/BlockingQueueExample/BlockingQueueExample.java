package week9.lab9.BlockingQueueExample;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(2);
        // BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);    // fix error 

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(4000);

    }

}
