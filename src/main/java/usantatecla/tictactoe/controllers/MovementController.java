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

	public Error getPutCoordinateError(Coordinate coordinate) {
		return this.session.getPutCoordinateError(coordinate);
	}

	public Error getMoveOriginCoordinateError(Coordinate coordinate) {
		return this.session.getMoveOriginCoordinateError(coordinate);
	}

	public Error getMoveTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
		return this.session.getMoveTargetCoordinateError(originCoordinate, targetCoordinate);
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

	public void putTokenPlayerFromTurn(Coordinate coordinate) {
		this.session.putTokenPlayerFromTurn(coordinate);
	}

	public void moveTokenPlayerFromTurn(Coordinate[] coordinates) {
		this.session.moveTokenPlayerFromTurn(coordinates);
	}

	public void changeTurn() {
		this.session.changeTurn();
	}

	public char getTokenChar(Coordinate coordinate) {
		return this.session.getToken(coordinate).getChar();
	}

	public boolean isEmptyToken(Coordinate coordinate) {
		return this.session.getToken(coordinate) == null;
	}

	public int getCoordinateDimension() {
		return Coordinate.DIMENSION;
	}

	public int getValueFromTurn() {
		return this.session.getValueFromTurn();
	}

	public void continueState() {
		this.session.next();
	}

	public boolean isTicTacToe() {
		return this.session.isTicTacToe();
	}
}