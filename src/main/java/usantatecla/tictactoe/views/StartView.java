package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;

class StartView {

	Game game;

	StartView(Game game) {
		this.game = game;
	}

    void interact() {
		MessageView.START_GAME.writeln();
		int numberOfPlayers = new ChoosePlayerView().readPlayers();
		this.game.createPlayers(numberOfPlayers);
		new BoardView(this.game.getBoard()).write();
	}
}