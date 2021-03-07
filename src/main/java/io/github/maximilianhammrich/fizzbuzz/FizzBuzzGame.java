package io.github.maximilianhammrich.fizzbuzz;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class FizzBuzzGame {
  private final List<GameCheck> gameChecks;

  public static FizzBuzzGame create(GameCheck... gameChecks) {
    var fizzBuzzGameCheckList = sortedListForArray(gameChecks);
    return new FizzBuzzGame(fizzBuzzGameCheckList);
  }

  private FizzBuzzGame(List<GameCheck> gameChecks) {
    this.gameChecks = gameChecks;
  }

  public String resultForNumber(int number) {
    var checksForNumber = checksForNumber(number);
    if (checksForNumber.isEmpty()) {
      return String.valueOf(number);
    }
    return runChecks(checksForNumber);
  }

  private String runChecks(List<GameCheck> checksForNumber) {
    var stringBuilder = new StringBuilder();
    for (var check : checksForNumber) {
      stringBuilder.append(check.output());
      if (check.behaviour() == FizzBuzzBehaviour.INTERRUPTING) {
        break;
      } else {
        spaceIfHasNext(stringBuilder, check, checksForNumber);
      }
    }
    return stringBuilder.toString();
  }

  private void spaceIfHasNext(
      StringBuilder stringBuilder, GameCheck check, List<GameCheck> checksForNumber) {
    var index = checksForNumber.indexOf(check);
    if (index + 1 < checksForNumber.size()) {
      stringBuilder.append(" ");
    }
  }

  private List<GameCheck> checksForNumber(int number) {
    return gameChecks.stream().filter(resultPredicate(number)).collect(Collectors.toList());
  }

  private Predicate<GameCheck> resultPredicate(int number) {
    return gameCheck -> gameCheck.matches(number);
  }

  private static List<GameCheck> sortedListForArray(GameCheck... gameChecks) {
    return Arrays.stream(gameChecks).sorted(comparator()).collect(Collectors.toList());
  }

  private static Comparator<GameCheck> comparator() {
    return Comparator.comparing(gameCheck -> gameCheck.behaviour().priority());
  }
}
