package io.github.maximilianhammrich.fizzbuzz;

public final class BuzzCheck implements FizzBuzzGameCheck {
  @Override
  public boolean matches(int number) {
    return number % 5 == 0;
  }

  @Override
  public String toString() {
    return "buzz";
  }
}
