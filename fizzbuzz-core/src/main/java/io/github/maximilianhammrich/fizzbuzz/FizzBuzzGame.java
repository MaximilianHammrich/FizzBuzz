package io.github.maximilianhammrich.fizzbuzz;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class FizzBuzzGame {
  private final List<FizzBuzzGameCheck> fizzBuzzGameChecks;

  public static FizzBuzzGame create(FizzBuzzGameCheck... fizzBuzzGameChecks) {
    var fizzBuzzGameCheckList = sortedListForArray(fizzBuzzGameChecks);
    return new FizzBuzzGame(fizzBuzzGameCheckList);
  }

  private FizzBuzzGame(List<FizzBuzzGameCheck> fizzBuzzGameChecks) {
    this.fizzBuzzGameChecks = fizzBuzzGameChecks;
  }

  public String resultForNumber(int number) {
    var checksForNumber = checksForNumber(number);
    if (checksForNumber.isEmpty()) {
      return String.valueOf(number);
    }
    return runChecks(checksForNumber);
  }

  private String runChecks(List<FizzBuzzGameCheck> checksForNumber) {
    StringBuilder stringBuilder = new StringBuilder();
    for (var check : checksForNumber) {
      stringBuilder.append(check.toString());
      if (check.behaviour() == FizzBuzzBehaviour.INTERRUPTING) {
        break;
      }else {
        spaceIfHasNext(stringBuilder, check, checksForNumber);
      }
    }
    return stringBuilder.toString();
  }

  private void spaceIfHasNext(
      StringBuilder stringBuilder,
      FizzBuzzGameCheck check,
      List<FizzBuzzGameCheck> checksForNumber) {
    var index = checksForNumber.indexOf(check);
    if (index + 1 < checksForNumber.size()) {
      stringBuilder.append(" ");
    }
  }

  private List<FizzBuzzGameCheck> checksForNumber(int number) {
    return fizzBuzzGameChecks.stream().filter(resultPredicate(number)).collect(Collectors.toList());
  }

  private Predicate<FizzBuzzGameCheck> resultPredicate(int number) {
    return fizzBuzzGameCheck -> fizzBuzzGameCheck.matches(number);
  }

  private static List<FizzBuzzGameCheck> sortedListForArray(
      FizzBuzzGameCheck... fizzBuzzGameChecks) {
    return Arrays.stream(fizzBuzzGameChecks).sorted(comparator()).collect(Collectors.toList());
  }

  private static Comparator<FizzBuzzGameCheck> comparator() {
    return Comparator.comparing(fizzBuzzGameCheck -> fizzBuzzGameCheck.behaviour().priority());
  }
}
