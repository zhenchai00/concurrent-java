package week6.lab6.Clinic;


public class Patients extends Thread {
    Doctor doc;
    int id;

    public Patients(int id, Doctor dr) {
        this.id = id;
        doc = dr;
    }

    public void run() {
        doc.visit(this);
    }
}
