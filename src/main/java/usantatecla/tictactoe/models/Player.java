package usantatecla.tictactoe.models;

class Player {

	private Token token;
	private Board board;

	Player(Token token, Board board) {
		assert token != null && !token.isNull();
		assert board != null;

		this.token = token;
		this.board = board;
	}

	Error put(Coordinate coordinate) {
		if (!this.board.isEmpty(coordinate)) {
			return Error.NOT_OWNER;
		}
		this.board.put(coordinate, this.token);
		return Error.NULL;
	}

	Error move(Coordinate origin, Coordinate target) {
		if (!this.board.isOccupied(origin, this.token)) {
			return Error.NOT_OWNER;
		}
		if (!this.board.isEmpty(target)) {
			return Error.NOT_EMPTY;
		} else if (origin.equals(target)) {
			return Error.SAME_COORDINATES;
		}
		this.board.move(origin, target);
		return Error.NULL;
	}

	Token getToken() {
		return this.token;
	}

}
