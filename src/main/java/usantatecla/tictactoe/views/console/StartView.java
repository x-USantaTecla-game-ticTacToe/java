package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.utils.WithConsoleView;

class StartView extends WithConsoleView {

	Game game;

	StartView(Game game) {
		this.game = game;
	}

    void interact() {
		this.console.writeln(MessageView.START_GAME.getMessage());
		int numberOfUsers = new ChoosePlayerView().readPlayers();
		this.game.createPlayers(numberOfUsers);
		new BoardView(this.game.getBoard()).write();
	}
}