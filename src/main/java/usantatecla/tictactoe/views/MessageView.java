package usantatecla.tictactoe.views;

import usantatecla.utils.Console;
import usantatecla.tictactoe.models.Turn;

enum MessageView {
	LINE_BREAK(""),
    EMPTY("-"), 
    SEPARATOR("-----------------------------------------------------"),
    VERTICAL_LINE_CENTERED(" | "),
	VERTICAL_LINE_LEFT("| "),
	PLAYER_WIN(" Player: You win!!! :-)"),
	START_GAME("-------------------- TIC TAC TOE --------------------"),
	CHOOSE_PLAYER("Number of users [0-" + Turn.NUM_PLAYERS + "] "),
	RESUME("Do you want to continue");

	private String message;
	
	private Console console;

	private MessageView(String message) {
		this.console = new Console();
		this.message = message;
	}

	String getMessage() {
		return this.message;
	}

	void write() {
		this.console.write(this.message);
	}

	void writeln() {
		this.console.writeln(this.message);
	}

}
