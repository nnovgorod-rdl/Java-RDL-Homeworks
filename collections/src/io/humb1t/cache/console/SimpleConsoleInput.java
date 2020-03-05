package io.humb1t.cache.console;

import java.util.Scanner;

public class SimpleConsoleInput {
  Scanner in = new Scanner(System.in);

  public String scannerInputToString() {
    return in.nextLine();
  }

  public void scannerClose() {
    in.close();
  }
}
