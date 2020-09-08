package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.TicTacToe;
import usantatecla.utils.Observer;

abstract class Command extends usantatecla.utils.Command {
	
	protected TicTacToe tictactoe;
	
	protected Command(String title, TicTacToe tictactoe, Observer observer) {
		this.title = title;
		this.tictactoe = tictactoe;
		this.addObserver(observer);
	}

}
