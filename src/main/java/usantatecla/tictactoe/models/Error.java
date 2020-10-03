package usantatecla.tictactoe.models;

public enum Error {

	NOT_EMPTY,
	NOT_OWNER,
	SAME_COORDINATES,
	WRONG_COORDINATES,
	NULL_ERROR;

	public boolean isNull(){
		return this == Error.NULL_ERROR;
	}

}
