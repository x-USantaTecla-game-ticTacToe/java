package usantatecla.tictactoe.views;

import usantatecla.tictactoe.types.Error;

public class ErrorView {

	public  static final String[] MESSAGES = {
		"The coordinates are wrong",
		"The square is not empty",
		"There is not a token of yours", 
		"The origin and target squares are the same",
		"Wrong number of users" };

	protected Error error;

	public ErrorView(Error error) {
		this.error = error;
	}

}
