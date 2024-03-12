package week3.lecture3.sample2;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Thread1 Alphabets = new Thread1();
		Thread2 Numbers = new Thread2();
		Alphabets.start();
		Numbers.start();

	}

}
