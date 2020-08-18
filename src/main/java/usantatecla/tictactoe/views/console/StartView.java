package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.models.Turn;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.utils.PlayersDialog;
import usantatecla.utils.WithConsoleView;

class StartView extends WithConsoleView {

	private StartController startController;

	StartView(StartController startController) {
		this.startController = startController;
	}

    void interact() {
		this.console.writeln(MessageView.START_GAME.getMessage());
		int numberOfUsers = new PlayersDialog().read(Turn.NUM_PLAYERS);
		this.startController.createPlayers(numberOfUsers);
	}
}