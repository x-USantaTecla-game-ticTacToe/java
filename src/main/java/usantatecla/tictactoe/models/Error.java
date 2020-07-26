package usantatecla.tictactoe.models;

import usantatecla.utils.Console;

enum Error {

	NOT_EMPTY("The square is not empty"),
	NOT_OWNER("There is not a token of yours"),
	SAME_COORDINATES("The origin and target squares are the same");

	private String message;

	Error(String message){
		this.message = message;
	}

	void writeln() {
		new Console().writeln(this.message);
	}

}
