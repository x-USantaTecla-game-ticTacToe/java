package usantatecla.utils;

public class NullCoordinate implements Coordinate {

	public static NullCoordinate instance;
	
	public static Coordinate instance() {
		if (NullCoordinate.instance == null) {
			NullCoordinate.instance = new NullCoordinate();
		}
		return NullCoordinate.instance; 
	}
	
	@Override
	public boolean isNull() {
		return true;
	}
	
	@Override
	public Direction getDirection(Coordinate coordinate) {
		assert coordinate != null;

		return Direction.NULL;
	}
	@Override
	public boolean inHorizontal(Coordinate coordinate) {
		assert coordinate != null;

		return false;
	}

	@Override
	public boolean inVertical(Coordinate coordinate) {
		assert coordinate != null;

		return false;
	}

	@Override
	public boolean inMainDiagonal() {
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
