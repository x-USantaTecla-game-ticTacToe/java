package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;
import usantatecla.utils.LimitedIntDialog;

class StartView {

	private Game game;

	StartView(Game game) {
		this.game = game;
	}

  void interact() {
		Message.TITTLE.writeln();
		int users = new LimitedIntDialog(0, 
			this.game.getMaxPlayers()).read(Message.NUMBER_PLAYERS.toString());
		this.game.setUsers(users);
		new GameView(this.game).write();
	}

}