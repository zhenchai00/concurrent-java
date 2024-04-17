package week7.lecture7.DiningNetbeans;

import java.awt.*;

class Philosopher extends Thread {
  private int identity;
  private PhilCanvas view;
  private Diners controller;
  private Fork left;
  private Fork right;

  Philosopher(Diners ctr, int id, Fork l, Fork r) {
    controller = ctr;
    view = ctr.display;
    identity = id;
    left = l;
    right = r;
  }

  public void run() {
    try {
      // while (true) {
      // // thinking
      // view.setPhil(identity, view.THINKING);
      // sleep(controller.sleepTime());
      // // hungry
      // view.setPhil(identity, view.HUNGRY);
      // right.get();
      // // gotright chopstick
      // view.setPhil(identity, view.GOTRIGHT);
      // sleep(500);
      // if (left.getStatus()) { // 3 no pre-emption
      // right.put();
      // } else {
      // left.get();
      // view.setPhil(identity, view.GOTLEFT);
      // sleep(500);
      // // eating
      // view.setPhil(identity, view.EATING);
      // sleep(controller.eatTime());
      // right.put();
      // left.put();
      // }
      // }

      // introduction asymmetry
      while (true) {
        // thinking
        view.setPhil(identity, view.THINKING);
        sleep(controller.sleepTime());
        // hungry
        view.setPhil(identity, view.HUNGRY);

        if (identity % 2 == 0) {
          // gotleft chopstick
          left.get();
          view.setPhil(identity, view.GOTRIGHT);
          sleep(500);
          right.get();
        } else {
          // gotright chopstick
          right.get();
          view.setPhil(identity, view.GOTLEFT);
          sleep(500);
          left.get();
        }
        // eating
        view.setPhil(identity, view.EATING);
        sleep(controller.eatTime());
        right.put();
        left.put();
      }

    } catch (java.lang.InterruptedException e) {
    }
  }
}
