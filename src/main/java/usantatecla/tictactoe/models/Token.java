package usantatecla.tictactoe.models;

import usantatecla.utils.ClosedInterval;

public enum Token {

	X,
	Y,
	NULL;

	public boolean isNull() {
		return this.equals(Token.NULL);
	}

	static Token get(int ordinal){
		assert new ClosedInterval(0, Token.values().length-2).isIncluded(ordinal);
		
		return Token.values()[ordinal];
	}

}
