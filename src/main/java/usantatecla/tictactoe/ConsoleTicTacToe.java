package usantatecla.tictactoe;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.View;
import usantatecla.tictactoe.views.console.ConsoleView;

class ConsoleTicTacToe extends TicTacToe {

	@Override
	protected View createView(Game game) {
		return new ConsoleView(game);
	}

	public static void main(String[] args) {
		new ConsoleTicTacToe().play();
	}

}
