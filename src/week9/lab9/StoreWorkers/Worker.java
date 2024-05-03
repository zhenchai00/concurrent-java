package week9.lab9.StoreWorkers;

public class Worker extends Thread {

	String name;
	Store store;

	public Worker(String name, Store store) {
		this.name = name;
		this.store = store;

	}

	public void run() {
		try {
			store.access(this);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String name() {
		// TODO Auto-generated method stub
		return name;
	}
}
