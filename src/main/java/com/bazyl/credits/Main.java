package com.bazyl.credits;

public class Main {

  public static void main(String[] args) {
    Controller controller = new Controller(new View(), new Model(0, 100));
    controller.processUser();
  }
}
