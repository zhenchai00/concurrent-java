package week2.lab2;

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

		RunnableThread R1 = new RunnableThread("Thread-1");
		Thread R1Thread = new Thread(R1);
		R1Thread.start();
		RunnableThread R2 = new RunnableThread("Thread-2");
		Thread R2Thread = new Thread(R2);
		R2Thread.start();
	}
	
}
