package usantatecla.tictactoe;

class UserPlayer extends Player {

	UserPlayer(Token token, Board board) {
		super(token, board);
	}

	@Override
	void put() {
		Coordinate coordinate = new Coordinate();
		Error error;
		do {
			error = null;
			coordinate.read("Enter a coordinate to put a token:");
			if (!this.board.isEmpty(coordinate)) {
				error = Error.NOT_EMPTY;
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
			originCoordinate.read("Enter a coordinate to remove a token:");
			if (!this.board.isOccupied(originCoordinate, this.token)) {
				error = Error.NOT_OWNER;
				error.writeln();
			}
		} while (error != null);
		Coordinate targetCoordinate = new Coordinate();
		do {
			error = null;
			targetCoordinate.read("Enter a coordinate to put a token:");
			if (originCoordinate.equals(targetCoordinate)) {
				error = Error.SAME_COORDINATES;
				error.writeln();
			} else if (!this.board.isEmpty(targetCoordinate)) {
				error = Error.NOT_EMPTY;
				error.writeln();
			}
		} while (error != null);
		this.board.move(originCoordinate, targetCoordinate);
	}

}
