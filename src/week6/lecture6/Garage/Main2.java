package week6.lecture6.Garage;

public class Main2 {

	public static void main(String[] args) throws InterruptedException {
		Car mercedes = new Car("Mercedes");
		Car audi = new Car("Audi");
		Mechanic M1 = new Mechanic("Mechanic", mercedes);
		M1.start();
		M1.join();
		VacuumCleaner theVacuum = new VacuumCleaner();
		VacuumGuy V1 = new VacuumGuy("Vacuum Guy 1", theVacuum, mercedes);
		V1.start();
		M1 = new Mechanic("Mechanic", audi);
		M1.start();
		M1.join();
		VacuumGuy V2 = new VacuumGuy("Vacuum Guy 2", theVacuum, audi);
		V2.start();

	}

}
