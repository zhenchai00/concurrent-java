package week1.labFQ19;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer> xValues = new ArrayList<Integer>();
    public static void main(String[] args) {
        Scanner nInput = new Scanner(System.in);
        System.out.print("Enter N: ");

        int nValue = nInput.nextInt();

        while (nValue > 0) {
            Scanner xInput = new Scanner(System.in);
            System.out.print("Enter X: ");
            int xValue = xInput.nextInt();
            xValues.add(xValue);
            nValue--;
        }

        double total = 0;
        double average = 0;

        for (int i = 0; i < xValues.size(); i++) {
            total =+ xValues.get(i);
            average = total / xValues.size();
        }

        System.out.println("the total = " + total);
        System.out.println("the average = " + average);
        System.out.println("Bye!");
    }
}
