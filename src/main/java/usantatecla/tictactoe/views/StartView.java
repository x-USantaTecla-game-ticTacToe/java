package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;
import usantatecla.utils.LimitedIntDialog;

class  StartView extends SubView {

	public StartView(Game game) {
		super(game);
	}

  void interact() {
		Message.TITTLE.writeln();
		int users = new LimitedIntDialog(0, 
			this.game.getMaxPlayers()).read(Message.NUMBER_PLAYERS.toString());
		this.game.setUsers(users);
		new GameView(this.game).write();
	}

}