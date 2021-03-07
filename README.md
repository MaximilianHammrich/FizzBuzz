# FizzBuzz

## Build Status

|             | Build Status                                                                                                            |
|-------------|-------------------------------------------------------------------------------------------------------------------------|
| Master      | ![Java CI with Gradle](https://github.com/MaximilianHammrich/FizzBuzz/workflows/Java%20CI%20with%20Gradle/badge.svg) |

## Inspiration

I got the inspiration for this simple project from a [video of Tom Scott]
(https://www.youtube.com/watch?v=QPZ0pIK_wsc&ab_channel=TomScott), which I can
only strongly recommend to watch, about exactly this project idea. The target
was to create the game with a base for further, easy changes and extensions in
an object-orientated manner.

## Requirements

- Java 15

## API

You can create a game by using the following lines:

```Java
final class TestLauncher {
  void createGame() {
    var fizzBuzzGame = FizzBuzzGame.create(new FizzCheck(), new BuzzCheck());
    assert fizzBuzzGame != null;
    String result = fizzBuzzGame.resultForNumber(exampleNumber);
  }
}
```

The arguments you give are standing for the individual checks you want to run on
every number you submit.

You can create individual checks like in the example below and add them to the
factory-method:

```Java
final class TestCheck implements FizzBuzzGameCheck {
  @Override
  public boolean matches(int number) {
    return number == 1;
  }

  @Override
  public String toString() {
    return "testAnswer";
  }
}
```