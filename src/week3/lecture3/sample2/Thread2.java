package week3.lecture3.sample2;

public class Thread2 extends Thread {
	public void run() {

		for (int i = 1; i <= 10; i++) {
			System.out.print(i);
		}

	}
}
