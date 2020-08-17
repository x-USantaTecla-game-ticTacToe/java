package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Turn;
import usantatecla.utils.PlayersDialog;

class StartView {

	Game game;

	StartView(Game game) {
		this.game = game;
	}

    void interact() {
		MessageView.START_GAME.writeln();
		int numberOfPlayers = new PlayersDialog().read(Turn.PLAYERS);
		this.game.createPlayers(numberOfPlayers);
		new BoardView(this.game.getBoard()).write();
	}
}