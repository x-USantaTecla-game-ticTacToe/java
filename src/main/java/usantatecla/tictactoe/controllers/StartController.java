package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;

public class StartController extends Controller {

  public StartController(Game game) {
    super(game);
  }

  public void setUsers(int users) {
    this.game.setUsers(users);
  }

public int getMaxPlayers() {
	return this.game.getMaxPlayers();
}

}
