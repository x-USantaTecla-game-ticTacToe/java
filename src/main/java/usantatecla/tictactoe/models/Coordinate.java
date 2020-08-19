package usantatecla.tictactoe.models;

import java.util.Random;

import usantatecla.utils.Direction;

public class Coordinate extends usantatecla.utils.Coordinate {

	public static final int DIMENSION = 3;

	public Coordinate() {
		super();
	}

	public Coordinate(int row, int column) {
		super(row, column);
	}

	boolean inDirection(Coordinate coordinate) {
		return this.getDirection(coordinate) != null;
	}

	Direction getDirection(Coordinate coordinate) {
		Direction direction = super.getMainDirection(coordinate);
		if (direction != null) {
			return direction;
		}
		if (this.inInverseDiagonal() && coordinate.inInverseDiagonal()) {
			return Direction.INVERSE_DIAGONAL;
		}
		return null;
	}

	private boolean inInverseDiagonal() {
		return this.row + this.column == Coordinate.DIMENSION - 1;
	}

	public boolean isValid() {
		return this.row >= 0 && this.row < Coordinate.DIMENSION && this.column >= 0
				&& this.column < Coordinate.DIMENSION;
	}

	public void random() {
		Random random = new Random(System.currentTimeMillis());
		this.row = random.nextInt(Coordinate.DIMENSION);
		this.column = random.nextInt(Coordinate.DIMENSION);
	}

}
