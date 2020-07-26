package usantatecla.tictactoe.models;

import usantatecla.utils.WithConsoleModel;

public abstract class Player extends WithConsoleModel {

	protected Token token;

	protected Board board;

	public Player(Token token, Board board) {
		this.token = token;
		this.board = board;
	}

	abstract void put();

	abstract void move();

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
