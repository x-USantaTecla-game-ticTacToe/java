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
			originCoordinate.read(ENTER_COORDINATE_TO_REMOVE);
			error = controlErrorsMoveOriginCoordinate(originCoordinate);
			if (error != null) {
				error.writeln();
			}
		} while (error != null);
		Coordinate targetCoordinate = new Coordinate();
		do {
			targetCoordinate.read(ENTER_COORDINATE_TO_PUT);
			error = controlErrorsMoveTargetCoordinate(originCoordinate, targetCoordinate);
			if (error != null) {
				error.writeln();
			}
		} while (error != null);
		this.board.move(originCoordinate, targetCoordinate);
	}

}
