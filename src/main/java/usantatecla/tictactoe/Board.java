package usantatecla.tictactoe;

import usantatecla.utils.Direction;

class Board {

	private Coordinate[][] coordinates;

	Board() {
		this.coordinates = new Coordinate[Turn.PLAYERS][Coordinate.DIMENSION];
		for (int i = 0; i < Turn.PLAYERS; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				this.coordinates[i][j] = null;
			}
		}
	}

	void write() {
		Message.SEPARATOR.writeln();
		for (int i = 0; i < Coordinate.DIMENSION; i++) {
			this.printRowBoard(i);
		}
		Message.SEPARATOR.writeln();
	}

	void move(Coordinate originCoordinate, Coordinate coordinate) {
		Token token = this.getToken(originCoordinate);
		this.remove(originCoordinate);
		this.put(coordinate, token);
	}

	void put(Coordinate coordinate, Token token) {
		int i = 0;
		while (this.coordinates[token.ordinal()][i] != null) {
			i++;
		}
		this.coordinates[token.ordinal()][i] = coordinate;
	}

	boolean isTicTacToe(Token token) {
		Coordinate[] coordinates = this.coordinates[token.ordinal()];
		return this.checkNumberOfCoordinates(coordinates) && this.checkDirectionOfFirstCoordinates(coordinates)
				&& this.checkDirectionOfAllCoordinates(coordinates);
	}

	boolean isCompleted() {
		for (int i = 0; i < Turn.PLAYERS; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				if (this.coordinates[i][j] == null) {
					return false;
				}
			}
		}
		return true;
	}

	boolean isEmpty(Coordinate coordinate) {
		return this.isOccupied(coordinate, null);
	}

	boolean isOccupied(Coordinate coordinate, Token token) {
		return this.getToken(coordinate) == token;
	}

	private void printRowBoard(int row) {
		Message.VERTICAL_LINE_LEFT.write();
		for (int j = 0; j < Coordinate.DIMENSION; j++) {
			this.printSquareValueBoard(row, j);
		}
		Message.LINE_BREAK.writeln();
	}

	private void printSquareValueBoard(int row, int column) {
		Token tokenToWrite = this.getToken(new Coordinate(row, column));
		if (tokenToWrite == null) {
			Message.EMPTY.write();
		} else {
			tokenToWrite.write();
		}
		Message.VERTICAL_LINE_CENTERED.write();
	}

	private Token getToken(Coordinate coordinate) {
		for (int i = 0; i < Turn.PLAYERS; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				if (this.coordinates[i][j] != null && this.coordinates[i][j].getRow() == coordinate.getRow()
						&& this.coordinates[i][j].getColumn() == coordinate.getColumn()) {
					return Token.values()[i];
				}
			}
		}
		return null;
	}

	private void remove(Coordinate coordinate) {
		for (int i = 0; i < Turn.PLAYERS; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				if (this.coordinates[i][j] != null && this.coordinates[i][j].getRow() == coordinate.getRow()
						&& this.coordinates[i][j].getColumn() == coordinate.getColumn()) {
					this.coordinates[i][j] = null;
				}
			}
		}
	}

	private boolean checkNumberOfCoordinates(Coordinate[] coordinates) {
		return this.numberOfCoordinates(coordinates) == Coordinate.DIMENSION;
	}

	private boolean checkDirectionOfFirstCoordinates(Coordinate[] coordinates) {
		return coordinates[0].inDirection(coordinates[1]);
	}

	private boolean checkDirectionOfAllCoordinates(Coordinate[] coordinates) {
		Direction direction = coordinates[0].getDirection(coordinates[1]);
		for (int i = 1; i < coordinates.length - 1; i++) {
			if (direction != coordinates[i].getDirection(coordinates[i + 1])) {
				return false;
			}
		}
		return true;
	}

	private int numberOfCoordinates(Coordinate[] coordinates) {
		int count = 0;
		for (int i = 0; i < coordinates.length; i++) {
			if (coordinates[i] != null) {
				count++;
			}
		}
		return count;
	}

}
