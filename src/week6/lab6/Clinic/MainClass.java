package week6.lab6.Clinic;

public class MainClass {
    public static void main(String ar[]) {
        Doctor doc = new Doctor();
        Patients u1 = new Patients(1, doc);
        Patients u2 = new Patients(2, doc);
        Patients u3 = new Patients(3, doc);
        Patients u4 = new Patients(4, doc);

        u1.start();
        u2.start();
        u3.start();
        u4.start();
    }
}
