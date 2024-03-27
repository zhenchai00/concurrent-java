package week5.lecture5.Garage;

public class Main {

	public static void main(String[] args) throws InterruptedException  {
		
		Mechanic M1 = new Mechanic("Mechanic");
		M1.start();
		 M1.join();

		TyreMan T1 = new TyreMan("Tyre Guy");
		T1.start();
		T1.join();

		PolishGuy P1 = new PolishGuy("Polish Guy");
		P1.start();
		 P1.join();

		VacuumGuy V1 = new VacuumGuy("Vacuum Guy");
		V1.start();
		V1.join();

	}
}
