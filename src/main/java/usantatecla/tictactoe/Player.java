package usantatecla.tictactoe;

abstract class Player {

	protected Token token;
	protected Board board;

	Player(Token token, Board board) {
		assert token != null && !token.isNull();
		assert board != null;
		
		this.token = token;
		this.board = board;
	}

	void play() {
		if (!this.board.isCompleted()) {
			this.put();
		} else {
			this.move();
		}
	}

	private void put() {
		Error error;
		Coordinate coordinate;
		do {
			coordinate = this.getCoordinate(Message.ENTER_COORDINATE_TO_PUT);
			error = this.checkPutCoordinateError(coordinate);
		} while (error != Error.NULL_ERROR);
		this.board.put(coordinate, this.token);
	}

	protected abstract Coordinate getCoordinate(Message message);

	protected Error checkPutCoordinateError(Coordinate coordinate) {
		if (!this.board.isEmpty(coordinate)) {
			return Error.NOT_EMPTY;
		}
		return Error.NULL_ERROR;
	}

	private void move() {
		Error error;
		Coordinate originCoordinate;
		do {
			originCoordinate = this.getCoordinate(Message.COORDINATE_TO_REMOVE);
			error = this.checkMoveOriginCoordinateError(originCoordinate);
		} while (error != Error.NULL_ERROR);
		Coordinate targetCoordinate;
		do {
			targetCoordinate = this.getCoordinate(Message.COORDINATE_TO_MOVE);
			error = this.checkMoveTargetCoordinateError(originCoordinate, targetCoordinate);
		} while (error != Error.NULL_ERROR);
		this.board.move(originCoordinate, targetCoordinate);
	}

	protected Error checkMoveOriginCoordinateError(Coordinate originCoordinate) {
		assert originCoordinate != null;

		if (!this.board.isOccupied(originCoordinate, this.token)) {
			return Error.NOT_OWNER;
		}
		return Error.NULL_ERROR;
	}

	protected Error checkMoveTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
		assert originCoordinate != null;
		
		if (originCoordinate.equals(targetCoordinate)) {
			return Error.SAME_COORDINATES;
		} 
		if (!this.board.isEmpty(targetCoordinate)) {
			return Error.NOT_EMPTY;
		}
		return Error.NULL_ERROR;
	}

	void writeWinner() {
		this.token.write();
		Message.PLAYER_WIN.writeln();
	}
	
	Token getToken() {
		return this.token;
	}
	
}
