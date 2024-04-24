package week8.lecture8.Week10Lab;

import java.awt.*;

class Bridge {
    private int nRed = 0;
    private int nBlue = 0;
    // private int waitRed = 0;
    // private int waitBlue = 0;
    private boolean blueTurn = true;

    synchronized void redEnter() throws InterruptedException {
        // ++waitRed;
        while (nBlue > 0 || (/* waitBlue > 0 &&  */blueTurn)) wait();
        // --waitRed;
        ++nRed;
    }

    synchronized void redExit() {
        --nRed;
        blueTurn = true;
        if (nRed == 0) {
            notifyAll();
        }
    }

    synchronized void blueEnter() throws InterruptedException {
        // ++waitBlue;
        while (nRed > 0 || (/* waitRed > 0 &&  */!blueTurn)) wait();
        // --waitBlue;
        ++nBlue;
    }

    synchronized void blueExit() {
        --nBlue;
        blueTurn = false;
        if (nBlue == 0) {
            notifyAll();
        }
    }
}
