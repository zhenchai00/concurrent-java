package week5.lecture5;


public class ThreadExtend extends Thread {

	private Thread t;
	private String threadName;
	
	ThreadExtend(String name){
		threadName=name;
		System.out.println("Creating "+threadName);
	}
	
	public void run() {
		System.out.println("Running "+threadName);
		try {
			for (int i=4; i>0; i--) {
				System.out.println("Thread:"+threadName + ", Loop: " +i);
				//Let thread sleep for a while
				Thread.sleep(500);
			}
		} catch(InterruptedException e) {
			System.out.println("Thread "+threadName + "interrupted.");
		}
		System.out.println("Thread "+threadName+ " exiting.");
	}

	// // This part run even we commented where this object is extending thread class not implementing
	public void start() {
		System.out.println("Starting "+threadName);
		if (t==null) {
			t=new Thread(this, threadName);
			t.start();
		}
	}
	
}
