package week5.lecture5;

public class RunnableThread implements Runnable {
	private Thread t;
    private String threadName;

    RunnableThread(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }
	
	public void run () {
		System.out.println("Running " + threadName);
		try {
			for (int i = 4; i > 0; i--) {
				System.out.println("Thread: " + threadName + ", Loop: " + i);
				Thread.sleep(0); // interleave the output
			}
		}  catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}
	
	// // This will not able to run if we comment this part where this object is implementing runnable interface not extending thread class
	// public void start () {
	// 	System.out.println("Starting " + threadName);
	// 	if (t == null) {
	// 		t = new Thread(this, threadName);
	// 		t.start();
	// 	}
	// }
}
