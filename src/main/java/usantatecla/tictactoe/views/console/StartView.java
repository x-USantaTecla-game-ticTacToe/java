package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.LimitedIntDialog;

class StartView extends SubView {

  StartView(Game game) {
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