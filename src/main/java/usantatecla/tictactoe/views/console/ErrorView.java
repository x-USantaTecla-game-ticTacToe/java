package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.types.Error;
import usantatecla.utils.Console;

class ErrorView extends usantatecla.tictactoe.views.ErrorView {

	ErrorView(Error error) {
		super(error);
	}
	
	void writeln() {
		if (!error.isNull()){
			Console.instance().writeln(ErrorView.MESSAGES[this.error.ordinal()]);
		}
	}

}
