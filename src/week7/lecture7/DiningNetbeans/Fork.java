package week7.lecture7.DiningNetbeans;

import java.awt.*;

class Fork {

  private boolean taken = false;
  private PhilCanvas display;
  private int identity;

  Fork(PhilCanvas disp, int id) {
    display = disp;
    identity = id;
  }

  synchronized void put() {
    taken = false;
    display.setFork(identity, taken);
    notify();
  }

  synchronized void get()
      throws java.lang.InterruptedException {
    while (taken)
      wait();
    taken = true;
    display.setFork(identity, taken);
  }

  public boolean getStatus() {
    return taken;
  }
}
