package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.utils.WithConsoleModel;

class StartView extends WithConsoleModel {

	Game game;

	StartView(Game game) {
		this.game = game;
	}

    void interact() {
		this.console.writeln(MessageView.START_GAME.getMessage());
		new ChoosePlayerView(this.game).readAndCreateUsers();
		new BoardView(this.game.getBoard()).write();
	}
}