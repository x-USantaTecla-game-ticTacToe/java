package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.StartController;
import usantatecla.utils.WithConsoleView;

class StartView extends WithConsoleView {

    void interact(StartController startController) {
		startController.start();
		this.console.writeln(MessageView.START_GAME.getMessage());
		int numberOfUsers = new ChoosePlayerView().readPlayers();
		startController.createPlayers(numberOfUsers);
	}
}