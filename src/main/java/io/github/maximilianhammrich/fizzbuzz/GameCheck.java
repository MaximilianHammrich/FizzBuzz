package io.github.maximilianhammrich.fizzbuzz;

public interface GameCheck {
  /** Whether the number is positive on the check. */
  boolean matches(int number);

  /** The output-string which is displayed */
  String output();

  default FizzBuzzBehaviour behaviour() {
    return FizzBuzzBehaviour.STACKING;
  }
}
