package usantatecla.tictactoe;

abstract class Player {

	protected Token token;

	protected Board board;

	Player(Token token, Board board) {
		this.token = token;
		this.board = board;
	}

	void put() {
		Coordinate coordinate = new Coordinate();
		Error error;
		do {
			error = this.readCoordinateToPut(coordinate);
		} while (error != null);
		this.board.put(coordinate, this.token);
	}

	void move() {
		Coordinate originCoordinate = new Coordinate();
		Error error;
		do {
			error = this.readCoordinateOriginToRemove(originCoordinate);
		} while (error != null);
		Coordinate targetCoordinate = new Coordinate();
		do {
			error = this.readCoordinateTargetToMove(originCoordinate, targetCoordinate);
		} while (error != null);
		this.board.move(originCoordinate, targetCoordinate);
	}

	abstract Error readCoordinateToPut(Coordinate coordinate);

	abstract Error readCoordinateOriginToRemove(Coordinate coordinate);

	abstract Error readCoordinateTargetToMove(Coordinate originCoordinate, Coordinate targetCoordinate);

	void writeWin(Token token) {
		token.write();
		Message.PLAYER_WIN.writeln();
	}

	Token getToken() {
		return this.token;
	}

	Error getErrorsPutCoordinate(Coordinate coordinate) {
		if (!board.isEmpty(coordinate)) {
			return Error.NOT_OWNER;
		}
		return null;
	}

	Error getErrorsMoveOriginCoordinate(Coordinate originCoordinate) {
		if (!board.isOccupied(originCoordinate, this.token)) {
			return Error.NOT_OWNER;
		}
		return null;
	}

	Error getErrorsMoveTargetCoordinate(Coordinate originCoordinate, Coordinate targetCoordinate) {
		if (originCoordinate.equals(targetCoordinate)) {
			return Error.SAME_COORDINATES;
		} else if (!board.isEmpty(targetCoordinate)) {
			return Error.NOT_EMPTY;
		}
		return null;
	}

}
