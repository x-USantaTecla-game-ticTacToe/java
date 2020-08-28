package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Turn;

public enum MessageView {
    EMPTY("-"), 
    SEPARATOR("-----------------------------------------------------"),
    VERTICAL_LINE_CENTERED(" | "),
	VERTICAL_LINE_LEFT("| "),
	PLAYER_WIN(" Player: You win!!! :-)"),
	START_GAME("-------------------- TIC TAC TOE --------------------"),
	CHOOSE_PLAYERS("Number of users [0-" + Turn.NUM_PLAYERS + "] "),
	READ_ROW("Row: "),
	READ_COLUMN("Column: "),
	ERROR("ERROR"),
	RESUME("Do you want to continue");

	private String message;

	private MessageView(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

}
