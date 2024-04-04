package week6.lecture6.Garage;

/**
 *
 * @author zailan
 */
public class VacuumCleaner {

	// Monitor - Shared objects need to be a monitor. Only one thread
	// can access a monitor at any one time.

	synchronized void useVacuum(VacuumGuy guy) throws InterruptedException {
		System.out.println(guy.threadName() + " is using vacuum1 on " + guy.car.carName);
		System.out.println(guy.threadName() + " vacuuming all seats.");
		Thread.sleep(5000);
		System.out.println(guy.threadName() + " returning the vacuum.");
	}

}
