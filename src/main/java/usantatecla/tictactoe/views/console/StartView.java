package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.utils.WithConsoleModel;

class StartView extends WithConsoleModel {

	private Logic logic;

	StartView(Logic logic) {
		this.logic = logic;
	}

    void interact() {
		this.console.writeln(MessageView.START_GAME.getMessage());
		int numberOfUsers = new ChoosePlayerView().readPlayers();
		this.logic.createPlayers(numberOfUsers);
		new BoardView(this.logic.getBoard()).write();
	}
}