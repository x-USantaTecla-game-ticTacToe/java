package usantatecla.tictactoe.views;

import usantatecla.utils.WithConsoleView;
import usantatecla.tictactoe.models.Error;

class ErrorView extends WithConsoleView {

	private static final String[] MESSAGES = { 
		"The square is not empty",
		"There is not a token of yours", 
		"The origin and target squares are the same",
		"The coordinates are wrong" };

	private Error error;

	ErrorView(Error error) {
		this.error = error;
	}
	
	void writeln() {
		this.console.writeln(ErrorView.MESSAGES[this.error.ordinal()]);
	}

}
