package io.humb1t.cache.console;

public class SimpleConsoleOutput {
  public void consoleOutput(String... text) {
    StringBuilder stringBuilder = new StringBuilder();
    for (String value : text) {
      stringBuilder.append(" ").append(value);
    }
    System.out.println(stringBuilder);
  }
}
