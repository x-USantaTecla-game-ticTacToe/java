package usantatecla.tictactoe;

import usantatecla.utils.Direction;

class Board {

	private final int NUMBER_PLAYERS;
	private Coordinate[][] coordinates;

	Board(int numberPlayers) {
		assert numberPlayers > 0;
		this.NUMBER_PLAYERS = numberPlayers;
		this.coordinates = new Coordinate[this.NUMBER_PLAYERS][Coordinate.DIMENSION];
		for (int i = 0; i < this.NUMBER_PLAYERS; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				this.coordinates[i][j] = NullCoordinate.instance();
			}
		}
	}

	void write() {
		Message.SEPARATOR.writeln();
		for (int i = 0; i<Coordinate.DIMENSION; i++) {
			Message.VERTICAL_LINE_LEFT.write();
			for (int j = 0; j<Coordinate.DIMENSION; j++) {
				this.getToken(new ConcreteCoordinate(i, j)).write();
				Message.VERTICAL_LINE_CENTERED.write();
			}
			Message.LINE_BREAK.writeln();
		}
		Message.SEPARATOR.writeln();
	}

	private Token getToken(Coordinate coordinate) {
		assert coordinate != null;
		assert !coordinate.equals(NullCoordinate.NULL_COORDINATE);
		for (int i = 0; i < this.NUMBER_PLAYERS; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				if (this.coordinates[i][j].equals(coordinate)) {
					return Token.get(i);
				}
			}
		}
		return Token.NULL_TOKEN;
	}

	boolean isCompleted() {
		for (int i = 0; i < this.NUMBER_PLAYERS; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				if (this.coordinates[i][j].equals(NullCoordinate.NULL_COORDINATE)) {
					return false;
				}
			}
		}
		return true;
	}

	void put(Coordinate coordinate, Token token) {
		assert coordinate != null;
		assert !coordinate.equals(NullCoordinate.NULL_COORDINATE);
		assert token != null;
		assert !token.equals(Token.NULL_TOKEN);
		Coordinate[] coordinates = this.coordinates[token.ordinal()];
		int i = 0;
		while (!coordinates[i].equals(NullCoordinate.NULL_COORDINATE)) {
			i++;
		}
		coordinates[i] = coordinate;
	}

	void move(Coordinate originCoordinate, Coordinate targetCoordinate) {
		assert originCoordinate != null;
		assert !originCoordinate.equals(NullCoordinate.NULL_COORDINATE);
		assert targetCoordinate != null;
		assert !targetCoordinate.equals(NullCoordinate.NULL_COORDINATE);
		Token token = this.getToken(originCoordinate);
		this.remove(originCoordinate);
		this.put(targetCoordinate, token);
	}

	private void remove(Coordinate coordinate) {
		assert coordinate != null;
		assert !coordinate.equals(NullCoordinate.NULL_COORDINATE);
		for (int i = 0; i < this.NUMBER_PLAYERS; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				if (this.coordinates[i][j].equals(coordinate)) {
					this.coordinates[i][j] = NullCoordinate.NULL_COORDINATE;
				}
			}
		}
	}

	boolean isOccupied(Coordinate coordinate, Token token) {
		assert coordinate != null;
		assert !coordinate.equals(NullCoordinate.NULL_COORDINATE);
		return this.getToken(coordinate) == token;
	}

	boolean isEmpty(Coordinate coordinate) {
		assert coordinate != null;
		assert !coordinate.equals(NullCoordinate.NULL_COORDINATE);
		return this.isOccupied(coordinate, Token.NULL_TOKEN);
	}

	boolean isTicTacToe(Token token) {
		assert token != null;
		assert !token.equals(Token.NULL_TOKEN);
		Coordinate[] coordinates = this.coordinates[token.ordinal()];
		for(int i=0; i<Coordinate.DIMENSION; i++){
			if (coordinates[i].equals(NullCoordinate.NULL_COORDINATE)) {
				return false;
			}
		}
		Direction direction = coordinates[0].getDirection(coordinates[1]);
		if (direction == Direction.NULL_DIRECTION){
			return false;
		}
		return direction == coordinates[1].getDirection(coordinates[2]);
	}

}
