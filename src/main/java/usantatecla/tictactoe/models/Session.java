package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.types.StateValue;
import usantatecla.tictactoe.types.Token;

public class Session {

  private State state;

  private Game game;

  private Registry registry;

  public Session() {
    this.state = new State();
    this.game = new Game();
    this.registry = new Registry(this.game);
  }

  public void next() {
    this.state.next();
  }

  public boolean undoable() {
    return this.registry.undoable();
  }

  public boolean redoable() {
    return this.registry.redoable();
  }

  public void undo() {
    this.registry.undo(this.game);
  }

  public void redo() {
    this.registry.redo(this.game);
  }

  public void createPlayers(int numberOfUsers) {
    this.game.createPlayers(numberOfUsers);
    this.registry.registry();
  }

  public PlayerType getTypeOfTokenPlayerFromTurn() {
    return this.game.getTypeOfTokenPlayerFromTurn();
  }

  private Error getPutCoordinateError(Coordinate coordinate) {
    return this.game.getPutCoordinateError(coordinate);
  }

  private Error getMoveOriginCoordinateError(Coordinate originCoordinate) {
    return this.game.getMoveOriginCoordinateError(originCoordinate);
  }

  private Error getMoveTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
    return this.game.getMoveTargetCoordinateError(originCoordinate, targetCoordinate);
  }

  public boolean isBoardComplete() {
    return this.game.isBoardComplete();
  }

  public Error putTokenPlayerFromTurn(Coordinate coordinate) {
    Error error = this.getPutCoordinateError(coordinate);
    assert error == null;
    if (error != null) {
      return error;
    }
    this.game.putTokenPlayerFromTurn(coordinate);
    this.changeTurn();
    this.registry.registry();
    return null;
  }

  public Error moveTokenPlayerFromTurn(Coordinate[] coordinates) {
    Error error = this.getMoveOriginCoordinateError(coordinates[0]);
    assert error == null;
    if (error != null) {
      return error;
    }
    error = this.getMoveTargetCoordinateError(coordinates[0], coordinates[1]);
    assert error == null;
    if (error != null) {
      return error;
    }
    this.game.moveTokenPlayerFromTurn(coordinates);
    this.changeTurn();
    this.registry.registry();
    return null;
  }

  public void changeTurn() {
    this.game.changeTurn();
  }

  public Token getToken(Coordinate coordinate) {
    return this.game.getToken(coordinate);
  }

  public char getTokenChar(Coordinate coordinate) {
    return this.game.getToken(coordinate).getChar();
  }

  public boolean isEmptyToken(Coordinate coordinate) {
    return this.game.getToken(coordinate) == null;
  }

  public boolean isTicTacToe() {
    return this.game.isTicTacToe();
  }

  public int getValueFromTurn() {
    return this.game.getValueFromTurn();
  }

  public StateValue getValueState() {
    return this.state.getValueState();
  }

  public int getCoordinateDimension() {
    return Coordinate.DIMENSION;
  }

  public void newGame() {
    this.game.newGame();
    this.state.reset();
    this.registry.reset();
  }
}