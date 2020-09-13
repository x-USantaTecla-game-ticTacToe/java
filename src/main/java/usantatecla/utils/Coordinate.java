package usantatecla.utils;

public class Coordinate {

	protected int row;
	protected int column;
	static final String ROW = "Row: ";
	static final String COLUMN = "Column: ";

	protected Coordinate() {
	}

	protected Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}

	protected Direction getDirection(Coordinate coordinate) {
		if (this.inHorizontal(coordinate)) {
			return Direction.HORIZONTAL;
		}
		if (this.inVertical(coordinate)) {
			return Direction.VERTICAL;
		}
		if (this.inMainDiagonal() && coordinate.inMainDiagonal()) {
			return Direction.MAIN_DIAGONAL;
		}
		return Direction.NULL_DIRECTION;
	}

	private boolean inHorizontal(Coordinate coordinate) {
		return this.row == coordinate.row;
	}

	private boolean inVertical(Coordinate coordinate) {
		return this.column == coordinate.column;
	}

	private boolean inMainDiagonal() {
		return this.row - this.column == 0;
	}

	protected void read(String title) {
		Console console = Console.instance();
		console.writeln(title);
		this.row = console.readInt(Coordinate.ROW) - 1;
		this.column = console.readInt(Coordinate.COLUMN) - 1;
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Coordinate [row=" + row + ", column=" + column + "]";
	}
	
	

}
