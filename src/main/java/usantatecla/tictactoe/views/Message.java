package usantatecla.tictactoe.views;

import usantatecla.utils.Console;

public enum Message {
  TITTLE("--- TIC TAC TOE ---"),
	NUMBER_PLAYERS("Number of user"), 
	SEPARATOR("-------------"), 
	VERTICAL_LINE_LEFT("| "), 
	VERTICAL_LINE_CENTERED(" | "),
	VERTICAL_LINE_RIGHT(""), 
	ACTION_COMMAND("Do a action"), 
	UNDO_COMMAND("Undo previous action"), 
	REDO_COMMAND("Redo previous action"),
	ENTER_COORDINATE_TO_PUT("Enter a coordinate to put a token:"),
	ENTER_COORDINATE_TO_REMOVE("Enter a coordinate to remove a token:"), 
	COORDINATE_TO_PUT("Coordinate to put"),
	COORDINATE_TO_REMOVE("Origin coordinate to move"), 
	COORDINATE_TO_MOVE("Target coordinate to move"),
	PLAYER_WIN(" Player: You win!!! :-)"), 
	RESUME("Do you want to continue");

	private String message;

	private Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	public void write() {
		Console.instance().write(this.message);
	}

	public void writeln() {
		Console.instance().writeln(this.message);
	}

	@Override
	public String toString() {
		return this.message;
  }

}
