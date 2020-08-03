package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Player;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.types.Token;

public class MovementController extends Controller {
    
    public MovementController(Session session) {
		super(session);
	}

	public Player getTokenPlayerFromTurn() {
		return this.session.getTokenPlayerFromTurn();
	}

	public PlayerType getTypeOfTokenPlayerFromTurn() {
		return this.session.getTypeOfTokenPlayerFromTurn();
	}

	public Error controlErrorsPutCoordinate(int row, int column) {
		return this.session.controlErrorsPutCoordinate(new Coordinate(row, column));
	}

	public Error controlErrorsMoveOriginCoordinate(int originRow, int originColumn) {
		return this.session.controlErrorsMoveOriginCoordinate(new Coordinate(originRow, originColumn));
	}

	public Error controlErrorsMoveTargetCoordinate(int originRow, int originColumn, int targetRow, int targetColumn) {
		return this.session.controlErrorsMoveTargetCoordinate(new Coordinate(originRow, originColumn),
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

	public Token getToken(int row, int column) {
		return this.session.getToken(row, column);
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