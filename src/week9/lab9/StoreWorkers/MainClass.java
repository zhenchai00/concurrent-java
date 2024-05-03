package week9.lab9.StoreWorkers;

public class MainClass {
    public static void main(String ar[]) {
        Store store = new Store();

        Worker w1 = new Worker("John", store);
        Worker w2 = new Worker("Sam", store);
        w2.start();
        w1.start();
    }
}
