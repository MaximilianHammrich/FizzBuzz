package io.github.maximilianhammrich.fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

final class FizzBuzzGameTest {
  @Test
  public void testApplication() {
    var fizzBuzzGame =
        FizzBuzzGame.create(new FizzCheck(), new TestInterruptingCheck(), new BuzzCheck());
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
}
