package io.github.maximilianhammrich.fizzbuzz;

public final class BuzzCheck implements GameCheck {
  @Override
  public boolean matches(int number) {
    return number % 5 == 0;
  }

  public String output() {
    return "buzz";
  }
}
