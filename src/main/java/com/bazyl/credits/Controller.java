package com.bazyl.credits;

import java.util.Scanner;

class Controller {

  private View view;
  private Model model;

  Controller(View view, Model model) {
    this.view = view;
    this.model = model;
  }

  void processUser() {
    Scanner scanner = new Scanner(System.in);
    View.printMessage(String.valueOf(model.getSecretValue()));
    while (!isCorrectValue(tryToFindCorrectValue(scanner))) {
    }
    View.printMessage("The game is over!");
  }

  private int tryToFindCorrectValue(Scanner scanner) {
    View.printMessage(model.toString());
    View.printMessage(View.INPUT_VALUE_MSG);
    while (!scanner.hasNextInt()) {
      View.printMessage(View.ERROR_VALUE_MSG);
      View.printMessage(model.toString());
      View.printMessage(View.INPUT_VALUE_MSG);
      scanner.nextInt();
    }
    return scanner.nextInt();
  }

  private boolean isCorrectRange(int value) {
    if (value < model.getMinLimit() || value > model.getMaxLimit()) {
      View.printMessage(View.ERROR_RANGE_MSG);
      return false;
    }
    return true;
  }

  private boolean isCorrectValue(int value) {
    if (isCorrectRange(value)) {
      if (value == model.getSecretValue()) {
        return true;
      } else if (value < model.getSecretValue()) {
        model.setMinLimit(value);
      } else {
        model.setMaxLimit(value);
      }
    }
    return false;
  }
}
