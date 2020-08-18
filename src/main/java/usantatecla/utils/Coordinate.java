package usantatecla.utils;

public class Coordinate {

	protected int row;

	protected int column;

	protected Coordinate() {
	}

	protected Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}

	protected Direction getMainDirection(Coordinate coordinate) {
		if (this.inHorizontal(coordinate)) {
			return Direction.HORIZONTAL;
		}
		if (this.inVertical(coordinate)) {
			return Direction.VERTICAL;
		}
		if (this.inMainDiagonal() && coordinate.inMainDiagonal()) {
			return Direction.MAIN_DIAGONAL;
		}
		return null;
	}

	private boolean inMainDiagonal() {
		return this.row - this.column == 0;
	}

	private boolean inVertical(Coordinate coordinate) {
		return this.column == coordinate.column;
	}

	private boolean inHorizontal(Coordinate coordinate) {
		return this.row == coordinate.row;
	}

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object coordinateObject) {
		if (!(coordinateObject instanceof Coordinate)) {
			return false;
		}
		Coordinate coordinate = (Coordinate) coordinateObject;
		return this.column == coordinate.column && this.row == coordinate.row;
	}

}
