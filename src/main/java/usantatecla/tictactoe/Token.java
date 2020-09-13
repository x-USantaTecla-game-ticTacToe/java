package usantatecla.tictactoe;

import usantatecla.utils.ClosedInterval;
import usantatecla.utils.Console;

enum Token {

	X_TOKEN('X'),
	Y_TOKEN('O'),
	NULL_TOKEN(' ');

	private char symbol;

	private Token(char symbol){
		this.symbol = symbol;
	}
	
	public boolean isNull() {
		return this.equals(Token.NULL_TOKEN);
	}

	void write() {
		Console.instance().write(this.symbol);
	}

	static Token get(int ordinal){
		assert new ClosedInterval(0, Token.values().length).isIncluded(ordinal);
		
		return Token.values()[ordinal];
	}

}
