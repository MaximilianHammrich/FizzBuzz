package io.github.maximilianhammrich.fizzbuzz;

public enum FizzBuzzBehaviour {
  INTERRUPTING(0),
  STACKING(1);

  private final int priority;

  FizzBuzzBehaviour(int priority) {
    this.priority = priority;
  }

  public int priority() {
    return priority;
  }
}
