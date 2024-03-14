package week3.lab3.Garage;

public class Main {

	public static void main(String[] args) throws InterruptedException  {
		
		PolishGuy P1 = new PolishGuy("Polish Guy");
		P1.start();
		Mechanic M1 = new Mechanic("Mechanic");
		M1.start();
		VacuumGuy V1 = new VacuumGuy("Vacuum Guy");
		V1.start();
		TyreMan T1 = new TyreMan("Tyre Guy");
		T1.start();
				
	}

}
