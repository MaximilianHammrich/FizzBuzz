package io.github.maximilianhammrich.fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class FizzBuzzGameTest {
  private FizzBuzzGame fizzBuzzGame;

  @BeforeEach
  void init() {
    this.fizzBuzzGame =
        FizzBuzzGame.create(new FizzCheck(), new TestInterruptingCheck(), new BuzzCheck());
  }

  @Test
  void testApplication() {
    for (int i = 0; i < 100; i++) {
      if (i == 30) {
        Assertions.assertEquals("interrupted", fizzBuzzGame.resultForNumber(i));
      } else if (i % 3 == 0 && i % 5 == 0) {
        Assertions.assertEquals("fizz buzz", fizzBuzzGame.resultForNumber(i));
      } else if (i % 3 == 0) {
        Assertions.assertEquals("fizz", fizzBuzzGame.resultForNumber(i));
      } else if (i % 5 == 0) {
        Assertions.assertEquals("buzz", fizzBuzzGame.resultForNumber(i));
      } else {
        Assertions.assertEquals(String.valueOf(i), fizzBuzzGame.resultForNumber(i));
      }
    }
  }

  private static class TestInterruptingCheck implements GameCheck {
    @Override
    public boolean matches(int number) {
      return number == 30;
    }

    public String output() {
      return "interrupted";
    }

    @Override
    public FizzBuzzBehaviour behaviour() {
      return FizzBuzzBehaviour.INTERRUPTING;
    }
  }
}
