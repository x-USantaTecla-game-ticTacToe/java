package usantatecla.tictactoe;

import usantatecla.utils.Console;

enum Message {
    LINE_BREAK(""),
    EMPTY("-"), 
    SEPARATOR("-----------------------------------------------------"),
    VERTICAL_LINE_CENTERED(" | "),
	VERTICAL_LINE_LEFT("| "),
	PLAYER_WIN(" Player: You win!!! :-)"),
	START_GAME("-------------------- TIC TAC TOE --------------------");

	private String message;
	
	private Console console;

	private Message(String message) {
		this.message = message;
	}

	void write() {
		this.console.write(this.message);
	}

	void writeln() {
		this.console.writeln(this.message);
	}
    
}