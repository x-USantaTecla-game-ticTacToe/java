package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.Token;

class Player {

	private Token token;
	Board board;

	Player(Token token, Board board) {
		this.token = token;
		this.board = board;
	}

	Error put(Coordinate coordinate) {
		assert coordinate != null && !coordinate.isNull();

		if (!this.board.isEmpty(coordinate)) {
			return Error.NOT_EMPTY;
		}
		this.board.put(coordinate, this.token);
		return Error.NULL;
	}

	Error move(Coordinate origin, Coordinate target) {
		assert origin != null && !origin.isNull();
		assert target != null && !target.isNull();

		if (!this.board.isOccupied(origin, this.token)) {
			return Error.NOT_OWNER;
		}
		if (origin.equals(target)) {
			return Error.SAME_COORDINATES;
		} 
		if (!this.board.isEmpty(target)) {
			return Error.NOT_EMPTY;
		}
		this.board.move(origin, target);
		return Error.NULL;
	}

	Token getToken() {
		return this.token;
	}

	public Player copy(Board board) {
		return new Player(this.token, board);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (board == null) {
			if (other.board != null)
				return false;
		} else if (!board.equals(other.board))
			return false;
		if (token != other.token)
			return false;
		return true;
	}

}
