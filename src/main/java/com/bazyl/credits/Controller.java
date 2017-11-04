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
    View.printMessage(String.valueOf(model.getSecretValue()));
    guessSecretValue();
    View.printMessage(View.GAME_OVER_MSG);
  }

  private void guessSecretValue() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      int enteredValue = getEnteredValue(scanner);
      if (isCorrectRange(enteredValue)) {
        if (isCorrectValue(enteredValue)) {
          return;
        } else {
          setNewRangeBounds(enteredValue);
        }
      } else {
        View.printMessage(View.ERROR_RANGE_MSG);
      }
    }
  }

  private int getEnteredValue(Scanner scanner) {
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
    return value >= model.getMinLimit() && value <= model.getMaxLimit();
  }

  private boolean isCorrectValue(int value) {
    return isCorrectRange(value) && value == model.getSecretValue();
  }

  private void setNewRangeBounds(int value) {
    if (value < model.getSecretValue()) {
      model.setMinLimit(value);
    } else {
      model.setMaxLimit(value);
    }
  }
}
