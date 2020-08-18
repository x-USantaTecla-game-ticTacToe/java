package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.PlayerType;

public class MovementController extends Controller {
    
    public MovementController(Session session) {
		super(session);
	}

	public PlayerType getTypeOfTokenPlayerFromTurn() {
		return this.session.getTypeOfTokenPlayerFromTurn();
	}

	public Error getErrorsPutCoordinate(int row, int column) {
		return this.session.getErrorsPutCoordinate(new Coordinate(row, column));
	}

	public Error getErrorsMoveOriginCoordinate(int originRow, int originColumn) {
		return this.session.getErrorsMoveOriginCoordinate(new Coordinate(originRow, originColumn));
	}

	public Error getErrorsMoveTargetCoordinate(int originRow, int originColumn, int targetRow, int targetColumn) {
		return this.session.getErrorsMoveTargetCoordinate(new Coordinate(originRow, originColumn),
				new Coordinate(targetRow, targetColumn));
	}

	public boolean isCoordinateValid(int row, int column) {
		return new Coordinate(row, column).isValid();
	}

	public int[] generateRandomCoordinate() {
		Coordinate coordinateRandom = new Coordinate();
		coordinateRandom.random();
		int[] coordinate = new int[2];
		coordinate[0] = coordinateRandom.getRow();
		coordinate[1] = coordinateRandom.getColumn();
		return coordinate;
	}

	public boolean isBoardComplete() {
		return this.session.isBoardComplete();
	}

	public void putTokenPlayerFromTurn(int originRow, int originColumn) {
		this.session.putTokenPlayerFromTurn(new Coordinate(originRow, originColumn));
	}

	public void moveTokenPlayerFromTurn(int originRow, int originColumn, int targetRow, int targetColumn) {
		Coordinate[] coordinates = new Coordinate[2];
		coordinates[0] = new Coordinate(originRow, originColumn);
		coordinates[1] = new Coordinate(targetRow, targetColumn);
		this.session.moveTokenPlayerFromTurn(coordinates);
	}

	public void changeTurn() {
		this.session.changeTurn();
	}

	public char getTokenChar(int row, int column) {
		return this.session.getToken(row, column).getChar();
	}

	public boolean isEmptyToken(int row, int column) {
		return this.session.getToken(row, column) == null;
	}

	public int getCoordinateDimension() {
		return Coordinate.DIMENSION;
	}

	public void isTicTacToe() {
		if (this.session.isTicTacToe()) {
			this.session.next();
		};
	}
}