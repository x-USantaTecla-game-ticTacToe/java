package usantatecla.tictactoe.types;

public enum Token {

	TOKEN_X('X'),
	TOKEN_O('O');

	private char character;

	Token(char character){
		this.character = character;
	}

	public char getChar() {
		return this.character;
	}

}
