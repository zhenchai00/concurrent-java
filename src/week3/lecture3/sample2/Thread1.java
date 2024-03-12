package week3.lecture3.sample2;

public class Thread1 extends Thread {
	public void run() {
		char c;
		for (c = 'A'; c <= 'Z'; ++c)
			System.out.print(c);
	}

}
