package usantatecla.tictactoe;

import usantatecla.utils.ClosedInterval;
import usantatecla.utils.Console;

enum Token {

	X,
	O,
	NULL;

	public boolean isNull() {
		return this.equals(Token.NULL);
	}

	void write() {
		String string = this.name();
		if (this == Token.NULL){
			string = " ";
		}
		Console.instance().write(string);
	}

	static Token get(int ordinal){
		assert new ClosedInterval(0, Token.values().length-2).isIncluded(ordinal);
		
		return Token.values()[ordinal];
	}

}
