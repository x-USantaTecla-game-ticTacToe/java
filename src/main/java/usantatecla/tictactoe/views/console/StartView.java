package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.utils.WithConsoleModel;

class StartView extends WithConsoleModel {

	private StartController startController;

	StartView(StartController startController) {
		this.startController = startController;
	}

    void interact() {
		this.console.writeln(MessageView.START_GAME.getMessage());
		int numberOfUsers = new ChoosePlayerView().readPlayers();
		this.startController.createPlayers(numberOfUsers);
		new BoardView(this.startController.getBoard()).write();
	}
}