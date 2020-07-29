package usantatecla.tictactoe;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.console.ConsoleView;

class ConsoleTicTacToe {

	private Game game;

	private ConsoleView consoleView;

	ConsoleTicTacToe() {
		this.game = new Game();
		this.consoleView = new ConsoleView(this.game);
	}

	private void play() {
		this.consoleView.interact();
	}

	public static void main(String[] args) {
		new ConsoleTicTacToe().play();
	}

}
