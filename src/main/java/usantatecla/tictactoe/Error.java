package usantatecla.tictactoe;

import usantatecla.utils.Console;

enum Error {

	NOT_EMPTY("The square is not empty"),
	NOT_OWNER("There is not a token of yours"),
	SAME_COORDINATES("The origin and target squares are the same"),
	USERS_ERROR("Wrong number of users"),
	WRONG_COORDINATES("The coordinates are wrong");

	private String message;

	Error(String message){
		this.message = message;
	}

	void writeln() {
		new Console().writeln(this.message);
	}

}
