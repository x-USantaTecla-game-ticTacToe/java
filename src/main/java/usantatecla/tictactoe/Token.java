package usantatecla.tictactoe;

import usantatecla.utils.Console;

enum Token {

	X_TOKEN('X'),
	Y_TOKEN('O'),
	NULL_TOKEN(' ');

	private char symbol;
	private static Console console = new Console();

	private Token(char symbol){
		this.symbol = symbol;
	}

	void write() {
		Token.console.write(this.symbol);
	}

	static Token get(int position){
		return Token.values()[position];
	}

}
