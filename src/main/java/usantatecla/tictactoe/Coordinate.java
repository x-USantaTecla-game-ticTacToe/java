package usantatecla.tictactoe;

import usantatecla.utils.Direction;

interface Coordinate {
	
	static final int DIMENSION = 3;
	boolean isNull();
	Direction getDirection(Coordinate coordinate);
	boolean inInverseDiagonal();
	void read(String message);
	void random();
}
