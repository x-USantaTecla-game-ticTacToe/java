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
		} while (error != Error.NULL);
		this.board.put(coordinate, this.token);
	}

	protected abstract Coordinate getCoordinate(Message message);

	protected Error checkPutCoordinateError(Coordinate coordinate) {
		if (!this.board.isEmpty(coordinate)) {
			return Error.NOT_EMPTY;
		}
		return Error.NULL;
	}

	private void move() {
		Error error;
		Coordinate origin;
		do {
			origin = this.getCoordinate(Message.COORDINATE_TO_REMOVE);
			error = this.checkMoveOriginCoordinateError(origin);
		} while (error != Error.NULL);
		Coordinate target;
		do {
			target = this.getCoordinate(Message.COORDINATE_TO_MOVE);
			error = this.checkMoveTargetCoordinateError(origin, target);
		} while (error != Error.NULL);
		this.board.move(origin, target);
	}

	protected Error checkMoveOriginCoordinateError(Coordinate origin) {
		assert origin != null;

		if (!this.board.isOccupied(origin, this.token)) {
			return Error.NOT_OWNER;
		}
		return Error.NULL;
	}

	protected Error checkMoveTargetCoordinateError(Coordinate origin, Coordinate targetCoordinate) {
		assert origin != null;
		
		if (origin.equals(targetCoordinate)) {
			return Error.SAME_COORDINATES;
		} 
		if (!this.board.isEmpty(targetCoordinate)) {
			return Error.NOT_EMPTY;
		}
		return Error.NULL;
	}

	void writeWinner() {
		Message.PLAYER_WIN.writeln(this.token.name());
	}
	
	Token getToken() {
		return this.token;
	}
	
}
