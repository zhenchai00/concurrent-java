package week2.lab2;

public class Main {
	public static void main(String[] args) {
		RunnableThread R1 = new RunnableThread("Thread-1");
		R1.start();
		RunnableThread R2 = new RunnableThread("Thread-2");
		R2.start();
	}
	
}
