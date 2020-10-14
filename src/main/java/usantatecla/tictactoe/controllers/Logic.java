package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Error;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Token;

public class Logic {

  private Game game;
  private StartController startController;
  private PlayController playController;
  private ResumeController resumeController;

  public Logic() {
    this.game = new Game();
    this.startController = new StartController(this.game);
    this.playController = new PlayController(this.game);
  }

  public int getMaxPlayers() {
    return this.startController.getMaxPlayers();
  }

  public void setUsers(int users) {
    this.startController.setUsers(users);
  }

  public Token getToken() {
    return this.playController.getToken();
  }

  public void next() {
    this.playController.next();
  }

  public boolean isBoardComplete() {
    return this.playController.isBoardComplete();
  }

  public boolean isTicTacToe() {
    return this.playController.isTicTacToe();
  }

  public boolean isUser() {
    return this.playController.isUser();
  }

  public Error put(Coordinate coordinate) {
    return this.playController.put(coordinate);
  }

  public Error move(Coordinate origin, Coordinate target) {
    return this.playController.move(origin, target);
  }

  public Token getToken(Coordinate coordinate) {
    return this.playController.getToken(coordinate);
  }

  public void resume() {
    this.resumeController.resume();
  }

}
