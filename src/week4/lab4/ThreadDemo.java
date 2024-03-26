package week4.lab4;

//package concurrency;

import java.awt.*;
import java.applet.*;
//import concurrency.display.*;

class Rotator implements Runnable {

  public void run() {
    try {
      while (true)
        ThreadPanel.rotate();
    } catch (InterruptedException e) {
    }
  }
}

public class ThreadDemo extends Applet {
  ThreadPanel A;
  ThreadPanel B;
  ThreadPanel C;

  public void init() {
    A = new ThreadPanel("Thread A", Color.blue);
    B = new ThreadPanel("Thread B", Color.blue);
    C = new ThreadPanel("Thread C", Color.blue);
    add(A);
    add(B);
    add(C);
    setBackground(Color.lightGray);
  }

  public void start() {
    A.start(new Rotator());
    B.start(new Rotator());
    C.start(new Rotator());
  }

  public void stop() {
    A.stop();
    B.stop();
    C.stop();
  }
}
