package week9.lab9;

//Synchronized object demo for taking turns using an object

public class ThreadTest {
    private final Object flag = new Object();

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        ThreadA threadA = threadTest.new ThreadA();
        threadA.start();
        ThreadB threadB = threadTest.new ThreadB();
        threadB.start();
    }

    class ThreadA extends Thread { // Prints out even numbers up to 100
        @Override
        public void run() {
            synchronized (flag) {
                for (int i = 0; i <= 100; i += 2) {
                    flag.notify();
                    System.out.println("A" + i);
                    try {
                        flag.wait(); // A waits for B to notify before proceeding
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    class ThreadB extends Thread { // Prints out odd numbers up to 100
        @Override
        public void run() {
            synchronized (flag) {
                for (int i = 1; i < 100; i += 2) {
                    // flag.notify() // here should notify back the A for continue the process
                    System.out.println("B" + i);
                    try {
                        flag.wait(); // B waits for A to notify before proceeding
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // flag.notify() // here should notify back the A for continue the process
                }
            }
        }
    }
}