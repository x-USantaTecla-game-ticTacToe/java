package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.PlayerType;
public class PlayController extends Controller {

	public PlayController(Game game) {
		super(game);
	}

	public PlayerType getTypeOfTokenPlayerFromTurn() {
		return this.game.getTypeOfTokenPlayerFromTurn();
	}

	public Error getPutCoordinateError(Coordinate coordinate) {
		return this.game.getPutCoordinateError(coordinate);
	}

	public Error getMoveOriginCoordinateError(Coordinate originCoordinate) {
		return this.game.getMoveOriginCoordinateError(originCoordinate);
	}

	public Error getMoveTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
		return this.game.getMoveTargetCoordinateError(originCoordinate, targetCoordinate);
	}

	public boolean isCoordinateValid(Coordinate coordinate) {
		return coordinate.isValid();
	}

	public Coordinate generateRandomCoordinate() {
		Coordinate coordinateRandom = new Coordinate();
		coordinateRandom.random();
		return coordinateRandom;
	}

	boolean isBoardComplete() {
		return this.game.isBoardComplete();
	}

	public void putTokenPlayerFromTurn(Coordinate coordinate) {
		this.game.putTokenPlayerFromTurn(coordinate);
	}

	public void moveTokenPlayerFromTurn(Coordinate originCoordinate, Coordinate targetCoordinate) {
		Coordinate[] coordinates = new Coordinate[2];
		coordinates[0] = originCoordinate;
		coordinates[1] = targetCoordinate;
		this.game.moveTokenPlayerFromTurn(coordinates);
	}

	void changeTurn() {
		this.game.changeTurn();
	}

	public char getTokenChar(Coordinate coordinate) {
		return this.game.getToken(coordinate).getChar();
	}

	public boolean isEmptyToken(Coordinate coordinate) {
		return this.game.getToken(coordinate) == null;
	}

	int getCoordinateDimension() {
		return Coordinate.DIMENSION;
	}

	public int getValueFromTurn() {
        return this.game.getValueFromTurn();
    }

	public boolean isTicTacToe() {
		return this.game.isTicTacToe();
	}
}