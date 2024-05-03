package week9.lab9.StoreWorkers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Store {
	Lock l;

	public Store() {
		l = new ReentrantLock();
	}

	public void access(Worker w) throws InterruptedException {
		if (l.tryLock())
			System.out.println(w.name() + " accessed this function");
		l.unlock();
		// following is the solution
		// l.tryLock();
		// System.out.println(w.name() + " accessed this function");
		// l.unlock();
	}
}