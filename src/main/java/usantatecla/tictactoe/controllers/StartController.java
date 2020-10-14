package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.State;

public class StartController extends Controller {

  public StartController(Game game, State state) {
    super(game, state);
  }

  public void setUsers(int users) {
    this.game.setUsers(users);
    this.state.next();
  }

  public int getMaxPlayers() {
    return this.game.getMaxPlayers();
  }

}
