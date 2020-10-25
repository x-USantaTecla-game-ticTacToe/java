package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.StateValue;
import usantatecla.tictactoe.types.Token;

public class Session {

  private Game game;
  private GameRegistry registry;
  private State state;

  public Session() {
    this.state = new State();
    this.game = new Game();
  }

  public StateValue getValueState() {
    return this.state.getValueState();
  }

  public Token getToken(Coordinate coordinate) {
    return this.game.getToken(coordinate);
  }

  public void next() {
    this.state.next();
  }

  public void setUsers(int users) {
    this.game.setUsers(users);
    this.registry = new GameRegistry(this.game);
  }

  public int getMaxPlayers() {
    return this.game.getMaxPlayers();
  }

  public void reset() {
    this.game.reset();
    this.state.reset();
  }

  public boolean isBoardComplete() {
    return this.game.isBoardComplete();
  }

  public boolean isTicTacToe() {
    return this.game.isTicTacToe();
  }

  public Token getToken() {
    return this.game.getToken();
  }

  public boolean isUser() {
    return this.game.isUser();
  }

  public Error put(Coordinate coordinate) {
    Error error = this.game.put(coordinate);
    if (error.isNull()){
      this.registry.register();
    }
    return error;
  }

  public Error move(Coordinate origin, Coordinate target) {
    Error error = this.game.move(origin, target);
    if (error.isNull()){
      this.registry.register();
    }
    return error;
  }

  public void undo() {
    this.registry.undo();
    if (!this.game.isUser()){
      this.registry.undo();
    }
  }

  public boolean undoable() {
    return this.registry.isUndoable();
  }

  public void redo() {
    this.registry.redo();
  }

  public boolean redoable() {
    return this.registry.isRedoable();
  }

}
