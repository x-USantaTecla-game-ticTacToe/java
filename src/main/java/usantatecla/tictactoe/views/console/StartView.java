package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.models.Turn;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.utils.PlayersDialog;
import usantatecla.utils.WithConsoleView;

class StartView extends WithConsoleView {

	private Logic logic;

	StartView(Logic logic) {
		this.logic = logic;
	}

    void interact() {
		this.console.writeln(MessageView.START_GAME.getMessage());
		int numberOfUsers = new PlayersDialog().read(Turn.NUM_PLAYERS);
		this.logic.createPlayers(numberOfUsers);
	}
}