package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Error;
import usantatecla.utils.Console;

class ErrorView {

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
		if (!error.isNull()){
			Console.instance().writeln(ErrorView.MESSAGES[this.error.ordinal()]);
		}
	}

}
