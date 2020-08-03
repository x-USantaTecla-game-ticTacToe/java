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

	Error controlErrorsPutCoordinate(int row, int column) {
		return this.game.controlErrorsPutCoordinate(new Coordinate(row, column));
	}

	Error controlErrorsMoveOriginCoordinate(int originRow, int originColumn) {
		return this.game.controlErrorsMoveOriginCoordinate(new Coordinate(originRow, originColumn));
	}

	Error controlErrorsMoveTargetCoordinate(int originRow, int originColumn, int targetRow, int targetColumn) {
		return this.game.controlErrorsMoveTargetCoordinate(new Coordinate(originRow, originColumn),
				new Coordinate(targetRow, targetColumn));
	}

	boolean isCoordinateValid(int row, int column) {
		return new Coordinate(row, column).isValid();
	}

	int[] generateRandomCoordinate() {
		Coordinate coordinateRandom = new Coordinate();
		coordinateRandom.random();
		int[] coordinate = new int[2];
		coordinate[0] = coordinateRandom.getRow();
		coordinate[1] = coordinateRandom.getColumn();
		return coordinate;
	}

	boolean isBoardComplete() {
		return this.game.isBoardComplete();
	}

	void putTokenPlayerFromTurn(int originRow, int originColumn) {
		this.game.putTokenPlayerFromTurn(new Coordinate(originRow, originColumn));
	}

	void moveTokenPlayerFromTurn(int originRow, int originColumn, int targetRow, int targetColumn) {
		Coordinate[] coordinates = new Coordinate[2];
		coordinates[0] = new Coordinate(originRow, originColumn);
		coordinates[1] = new Coordinate(targetRow, targetColumn);
		this.game.moveTokenPlayerFromTurn(coordinates);
	}

	void changeTurn() {
		this.game.changeTurn();
	}

	char getTokenChar(int row, int column) {
		return this.game.getToken(row, column).getChar();
	}

	boolean isEmptyToken(int row, int column) {
		return this.game.getToken(row, column) == null;
	}

	int getCoordinateDimension() {
		return Coordinate.DIMENSION;
	}

	boolean isTicTacToe() {
		return this.game.isTicTacToe();
	}
}