package usantatecla.tictactoe;

abstract class Player {

	protected Token token;

	protected Board board;

	Player(Token token, Board board) {
		this.token = token;
		this.board = board;
	}

	abstract void put();

	abstract void move();

	void writeWin(Token token) {
		token.write();
		Message.PLAYER_WIN.writeln();
	}

	Token getToken() {
		return this.token;
	}

	Error controlErrorsPutCoordinate(Coordinate coordinate) {
		if (!board.isEmpty(coordinate)) {
			return Error.NOT_OWNER;
		}
		return null;
	}

	Error controlErrorsMoveOriginCoordinate(Coordinate originCoordinate) {
		if (!board.isOccupied(originCoordinate, this.token)) {
			return Error.NOT_OWNER;
		}
		return null;
	}

	Error controlErrorsMoveTargetCoordinate(Coordinate originCoordinate, Coordinate targetCoordinate) {
		if (originCoordinate.equals(targetCoordinate)) {
			return Error.SAME_COORDINATES;
		} else if (!board.isEmpty(targetCoordinate)) {
			return Error.NOT_EMPTY;
		}
		return null;
	}

}
