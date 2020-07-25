package usantatecla.tictactoe;

import usantatecla.utils.Console;

enum Token {

	TOKEN_X('X'),
	TOKEN_O('O');

	private char character;

	Token(char character){
		this.character = character;
	}

	void write() {
		new Console().write(this.character);
	}

}
