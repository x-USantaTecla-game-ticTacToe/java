package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.LimitedIntDialog;

class StartView {

	void interact(StartController startController) {
		Message.TITTLE.writeln();
		int users = new LimitedIntDialog(0, 
			startController.getMaxPlayers()).read(Message.NUMBER_PLAYERS.toString());
		startController.setUsers(users);
		new GameView(startController).write();
	}

}