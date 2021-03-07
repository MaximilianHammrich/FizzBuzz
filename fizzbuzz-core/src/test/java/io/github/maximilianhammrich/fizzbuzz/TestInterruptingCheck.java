package io.github.maximilianhammrich.fizzbuzz;

final class TestInterruptingCheck implements FizzBuzzGameCheck {
  @Override
  public boolean matches(int number) {
    return number == 30;
  }

  @Override
  public String toString() {
    return "interrupted";
  }

  @Override
  public FizzBuzzBehaviour behaviour() {
    return FizzBuzzBehaviour.INTERRUPTING;
  }
}
