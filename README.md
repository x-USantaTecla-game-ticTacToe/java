<h1 align="center">Welcome to TicTacToe. Versión 7.2. ** mvp.pm.withoutDoubleDispatching ** 👋</h1>
<p>
  <a href="/docs" target="_blank">
    <img alt="Documentation" src="https://img.shields.io/badge/documentation-yes-brightgreen.svg" />
  </a>
  <a href="#" target="_blank">
    <img alt="License: MIT" src="https://img.shields.io/badge/License-MIT-yellow.svg" />
  </a>
</p>

> TicTacToe. mvp.pm.withoutDoubleDispatching

## Install

```sh
mvn install
```

## Usage

For Console edition:

Edit pom.xml line 59 for this:

```sh
<mainClass>usantatecla.tictactoe.ConsoleTicTacToe</mainClass>
```
And then:

```sh
mvn clean
mvn package
java -jar target/tictactoe-1.0-SNAPSHOT.jar
```

For Graphics edition:

Edit pom.xml line 59 for this:

```sh
<mainClass>usantatecla.tictactoe.GraphicsTicTacToe</mainClass>
```
And then:

```sh
mvn clean
mvn package
java -jar target/tictactoe-1.0-SNAPSHOT.jar
```

## Run tests

```sh
mvn test
```

## Author

👤 **USantaTecla**

* Github: [@USantaTecla](https://github.com/USantaTecla)


Note that you should have to [install JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and [Maven](https://maven.apache.org/install.html) as prerequisite.
