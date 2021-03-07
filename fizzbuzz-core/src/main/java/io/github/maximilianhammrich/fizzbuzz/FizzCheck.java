package io.github.maximilianhammrich.fizzbuzz;

public final class FizzCheck implements FizzBuzzGameCheck {
  @Override
  public boolean matches(int number) {
    return number % 3 == 0;
  }

  @Override
  public String toString() {
    return "fizz";
  }
}
