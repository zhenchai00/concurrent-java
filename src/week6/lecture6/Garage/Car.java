package week6.lecture6.Garage;

public class Car {
    
    String carName;
    
    Car(String name){
		carName=name;

		System.out.println("** "+ carName+ " entered the shop! **");
	}
    
    synchronized void serviceCar(Mechanic guy) throws InterruptedException
	    {			
	        try {
			for (int i=4; i>0; i--) {
				switch (i) {
				  case 1:
				    System.out.println(guy.threadName+ " replacing fan belts for " + carName);
				    break;
				  case 2:
				    System.out.println(guy.threadName+ " checking "+carName+ " fan belts.");
				    break;
				  case 3:
					System.out.println(guy.threadName+ " replacing "+carName+" oil filter.");
					break;
				  case 4:
					System.out.println(guy.threadName+ " replacing "+carName+" engine oil.");
					break;
				    }
				Thread.sleep(500);
			}
		} catch(InterruptedException e) {
			System.out.println("Thread "+guy.threadName + "interrupted.");
		}
	    }
}
