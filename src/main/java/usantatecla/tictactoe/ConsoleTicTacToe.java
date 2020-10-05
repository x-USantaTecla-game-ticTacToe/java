package usantatecla.tictactoe;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.console.View;

class ConsoleTicTacToe {

	private Game game;
	private View view;

	ConsoleTicTacToe() {
		this.game = new Game();
		this.view = new View(this.game);
	}

	private void play() {
		this.view.interact();
	}

	public static void main(String[] args) {
		new ConsoleTicTacToe().play();
	}

}
