package week5.lecture5;

public class Main {
	public static void main(String[] args) {
		// RunnableThread R1 = new RunnableThread("Thread-1");
		// R1.start();
		// RunnableThread R2 = new RunnableThread("Thread-2");
		// R2.start();

		// ThreadExtend T1 = new ThreadExtend("Thread-1");
		// T1.start();
		// ThreadExtend T2 = new ThreadExtend("Thread-2");
		// T2.start();

		// RunnableThread R1 = new RunnableThread("Thread-1");
		// Thread R1Thread = new Thread(R1);
		// R1Thread.setPriority(0);
		// R1Thread.start();
		// RunnableThread R2 = new RunnableThread("Thread-2");
		// Thread R2Thread = new Thread(R2);
		// R2Thread.start();

		ThreadExtend T1 = new ThreadExtend("Thread-1");
		ThreadExtend T2 = new ThreadExtend("Thread-2");
		ThreadExtend T3 = new ThreadExtend("Thread-3");
		ThreadExtend T4 = new ThreadExtend("Thread-4");
		T1.setPriority(Thread.MIN_PRIORITY);
		T2.setPriority(Thread.MIN_PRIORITY);
		T3.setPriority(Thread.MIN_PRIORITY);
		T4.setPriority(Thread.MAX_PRIORITY);
		T1.start();
		T2.start();
		T3.start();
		T4.start();
	}
	
}
