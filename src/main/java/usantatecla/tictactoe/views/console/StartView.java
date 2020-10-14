package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.LimitedIntDialog;

class StartView extends SubView {

  StartView(Logic logic) {
		super(logic);
	}

	void interact() {
		Message.TITTLE.writeln();
		int users = new LimitedIntDialog(0, 
			this.logic.getMaxPlayers()).read(Message.NUMBER_PLAYERS.toString());
		this.logic.setUsers(users);
		new GameView(logic).write();
	}

}