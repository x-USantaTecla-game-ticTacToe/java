package usantatecla.tictactoe.types;

import usantatecla.utils.ClosedInterval;

public enum Token {

	X,
	O,
	NULL;

	public boolean isNull() {
		return this.equals(Token.NULL);
	}

	public static Token get(int ordinal){
		assert new ClosedInterval(0, Token.values().length-2).isIncluded(ordinal);
		
		return Token.values()[ordinal];
	}

	@Override
	public String toString(){
		if (this==Token.NULL){
			return ".";
		}
		return this.name();
	}

}
