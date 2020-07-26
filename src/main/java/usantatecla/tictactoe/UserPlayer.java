package usantatecla.tictactoe;

class UserPlayer extends Player {

	static final String ENTER_COORDINATE_TO_PUT = "Enter a coordinate to put a token:";
	static final String ENTER_COORDINATE_TO_REMOVE = "Enter a coordinate to remove a token:";

	UserPlayer(Token token, Board board) {
		super(token, board);
	}

	@Override
	void put() {
		Coordinate coordinate = new Coordinate();
		Error error;
		do {
			error = null;
			coordinate.read(ENTER_COORDINATE_TO_PUT);
			error = controlErrorsPutCoordinate(coordinate);
			if (error != null) {
				error.writeln();
			}
		} while (error != null);
		this.board.put(coordinate, this.token);
	}

	@Override
	void move() {
		Coordinate originCoordinate = new Coordinate();
		Error error;
		do {
			error = null;
			originCoordinate.read(ENTER_COORDINATE_TO_REMOVE);
			if (!this.board.isOccupied(originCoordinate, this.token)) {
				error = Error.NOT_OWNER;
				error.writeln();
			}
			error = controlErrorsMoveOriginCoordinate(originCoordinate);
			if (error != null) {
				error.writeln();
			}
		} while (error != null);
		Coordinate targetCoordinate = new Coordinate();
		do {
			error = null;
			targetCoordinate.read(ENTER_COORDINATE_TO_PUT);
			if (originCoordinate.equals(targetCoordinate)) {
				error = Error.SAME_COORDINATES;
				error.writeln();
			} else if (!this.board.isEmpty(targetCoordinate)) {
				error = Error.NOT_EMPTY;
				error.writeln();
			}
			error = controlErrorsMoveTargetCoordinate(originCoordinate, targetCoordinate);
			if (error != null) {
				error.writeln();
			}
		} while (error != null);
		this.board.move(originCoordinate, targetCoordinate);
	}

}
