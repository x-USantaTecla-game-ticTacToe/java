package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.types.Token;

public class Player {

	private Token token;

	private Board board;

	private PlayerType type;

	public Player(Token token, Board board, PlayerType type) {
		this.token = token;
		this.board = board;
		this.type = type;
	}

	public PlayerType getType() {
		return this.type;
	}

	void put(Coordinate coordinate) {
		this.board.put(coordinate, this.token);
	};

	void move(Coordinate[] coordinates) {
		this.board.move(coordinates[0], coordinates[1]);
	};

	Token getToken() {
		return this.token;
	}

	public Error getPutCoordinateError(Coordinate coordinate) {
		if (!this.board.isEmpty(coordinate)) {
			return Error.NOT_OWNER;
		}
		return null;
	}

	public Error getMoveOriginCoordinateError(Coordinate originCoordinate) {
		if (!this.board.isOccupied(originCoordinate, this.token)) {
			return Error.NOT_OWNER;
		}
		return null;
	}

	public Error getMoveTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
		if (originCoordinate.equals(targetCoordinate)) {
			return Error.SAME_COORDINATES;
		} else if (!this.board.isEmpty(targetCoordinate)) {
			return Error.NOT_EMPTY;
		}
		return null;
	}

}
