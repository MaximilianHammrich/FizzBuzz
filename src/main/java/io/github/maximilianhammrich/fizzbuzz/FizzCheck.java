package io.github.maximilianhammrich.fizzbuzz;

public final class FizzCheck implements GameCheck {
  @Override
  public boolean matches(int number) {
    return number % 3 == 0;
  }

  public String output() {
    return "fizz";
  }
}
