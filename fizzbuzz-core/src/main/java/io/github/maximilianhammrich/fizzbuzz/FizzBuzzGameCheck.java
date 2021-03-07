package io.github.maximilianhammrich.fizzbuzz;

public interface FizzBuzzGameCheck {
  boolean matches(int number);

  @Override
  String toString();

  default FizzBuzzBehaviour behaviour() {
    return FizzBuzzBehaviour.STACKING;
  }
}
