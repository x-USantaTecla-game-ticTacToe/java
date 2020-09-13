package usantatecla.tictactoe;

import usantatecla.utils.Console;

enum Message {
	LINE_BREAK(""), 
	EMPTY("-"), 
	START_GAME("--- TIC TAC TOE ---"), 
	SEPARATOR("-------------"),
	NUMBER_PLAYERS("Number of user"), 
	VERTICAL_LINE_LEFT("| "), 
	VERTICAL_LINE_CENTERED(" | "),
	ENTER_COORDINATE_TO_PUT("Enter a coordinate to put a token:"),
	ENTER_COORDINATE_TO_REMOVE("Enter a coordinate to remove a token:"), 
	COORDINATE_TO_PUT("Coordinate to put"),
	COORDINATE_TO_REMOVE("Origin coordinate to move"), 
	COORDINATE_TO_MOVE("Target coordinate to move"),
	PLAYER_WIN(" Player: You win!!! :-)"), 
	RESUME("Do you want to continue");

	private String message;
	private static Console console = new Console();

	private Message(String message) {
		this.message = message;
	}

	void write() {
		Message.console.write(this.message);
	}

	void writeln() {
		Message.console.writeln(this.message);
	}

	@Override
	public String toString() {
		return this.message;
	}

}