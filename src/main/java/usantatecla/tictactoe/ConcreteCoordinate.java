package usantatecla.tictactoe;

import java.util.Random;

import usantatecla.utils.ClosedInterval;
import usantatecla.utils.Direction;

class ConcreteCoordinate extends usantatecla.utils.Coordinate implements Coordinate {

	static final ClosedInterval LIMITS = 
		new ClosedInterval(0, Coordinate.DIMENSION);

	ConcreteCoordinate() {
		super();
	}

	ConcreteCoordinate(int row, int column) {
		super(row, column);
	}

	@Override
	public Direction getDirection(Coordinate coordinate) {
		Direction direction = super.getDirection((usantatecla.utils.Coordinate)coordinate);
		if (direction != Direction.NULL_DIRECTION) {
			return direction;
		}
		if (this.inInverseDiagonal() && coordinate.inInverseDiagonal()) {
			return Direction.INVERSE_DIAGONAL;
		}
		return Direction.NULL_DIRECTION;
	}

	public boolean inInverseDiagonal() {
		return this.row + this.column == Coordinate.DIMENSION - 1;
	}

	@Override
	public void read(String message) {
		boolean error;
		do {
			super.read(message);
			error = !LIMITS.isIncluded(this.row) || !LIMITS.isIncluded(this.column);
			if (error) {
				Error.WRONG_COORDINATES.writeln();
			}
		} while (error);
	}

	public void random() {
		Random random = new Random(System.currentTimeMillis());
		this.row = random.nextInt(Coordinate.DIMENSION);
		this.column = random.nextInt(Coordinate.DIMENSION);
	}
	
	

}
