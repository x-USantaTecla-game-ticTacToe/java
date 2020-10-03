package usantatecla.tictactoe.models;

import usantatecla.utils.ClosedInterval;

public enum Token {

	X_TOKEN,
	Y_TOKEN,
	NULL_TOKEN;

	public boolean isNull() {
		return this.equals(Token.NULL_TOKEN);
	}

	static Token get(int ordinal){
		assert new ClosedInterval(0, Token.values().length).isIncluded(ordinal);
		
		return Token.values()[ordinal];
	}

}
