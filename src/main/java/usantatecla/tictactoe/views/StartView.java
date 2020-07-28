package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;

class StartView {

	Game game;

	StartView(Game game) {
		this.game = game;
	}

    void interact() {
		MessageView.START_GAME.writeln();
		new ChoosePlayerView(this.game).readAndCreateUsers();
		new BoardView(this.game.getBoard()).write();
	}
}