package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.utils.WithConsoleView;

class StartView extends WithConsoleView {

    void interact(StartController startController) {
		startController.start();
		this.console.writeln(MessageView.START_GAME.getMessage());
		int numberOfUsers = new ChoosePlayerView().readPlayers();
		startController.createPlayers(numberOfUsers);
	}
}