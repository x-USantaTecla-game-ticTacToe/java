package usantatecla.tictactoe;

import usantatecla.utils.Direction;

class NullCoordinate implements Coordinate {

	public static NullCoordinate NULL_COORDINATE;
	
	public static Coordinate instance() {
		if (NullCoordinate.NULL_COORDINATE == null) {
			NullCoordinate.NULL_COORDINATE = new NullCoordinate();
		}
		return NullCoordinate.NULL_COORDINATE; 
	}
	
	@Override
	public boolean isNull() {
		return true;
	}
	
	@Override
	public Direction getDirection(Coordinate coordinate) {
		return Direction.NULL_DIRECTION;
	}

	@Override
	public void read(String message) {
	}

	@Override
	public void random() {
	}

	@Override
	public boolean inInverseDiagonal() {
		return false;
	}
	
	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NullCoordinate []";
	}
	
}
