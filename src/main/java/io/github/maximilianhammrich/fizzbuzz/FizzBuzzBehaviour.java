package io.github.maximilianhammrich.fizzbuzz;

public enum FizzBuzzBehaviour {
  /** Only the output of the first check that is interrupting would be shown */
  INTERRUPTING(0),
  /** If more than one check is positive the outputs will be combined to a single message */
  STACKING(1);

  private final int priority;

  FizzBuzzBehaviour(int priority) {
    this.priority = priority;
  }

  public int priority() {
    return priority;
  }
}
