package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.console.View;

class ConsoleTicTacToe extends TicTacToe {

	@Override
	protected View createView(Logic logic){
		return new View(logic);
	}

	public static void main(String[] args) {
		new ConsoleTicTacToe().play();
	}

}