package week6.lecture6.Garage;

public class VacuumGuy extends Thread {

	private Thread t;
	String threadName;
	VacuumCleaner vacuum;
	Car car;

	VacuumGuy(String name, VacuumCleaner theVacuum, Car car) {
		this.threadName = name;
		vacuum = theVacuum;
		this.car = car;
		System.out.println("** " + threadName + " reporting for work! **");
	}

	public void run() {
		try {
			vacuum.useVacuum(this);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("-- " + threadName + " done vacuuming! --");
	}

	public String threadName() {
		return this.threadName;
	}

}
