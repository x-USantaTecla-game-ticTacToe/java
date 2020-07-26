package usantatecla.tictactoe;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.View;
import usantatecla.utils.WithConsoleModel;

class TicTacToe extends WithConsoleModel{

	Game game;

	View view;

	TicTacToe() {
		this.game = new Game();
		this.view = new View(this.game);
	}

	private void play() {
		this.view.interact();
	}

	public static void main(String[] args) {
		new TicTacToe().play();
	}

}
