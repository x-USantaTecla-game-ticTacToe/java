package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.State;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.PlayerType;
public class PlayController extends Controller {

	public PlayController(Game game, State state) {
		super(game, state);
	}

	public PlayerType getTypeOfTokenPlayerFromTurn() {
		return this.game.getTypeOfTokenPlayerFromTurn();
	}

	public Error controlErrorsPutCoordinate(int row, int column) {
		return this.game.controlErrorsPutCoordinate(new Coordinate(row, column));
	}

	public Error controlErrorsMoveOriginCoordinate(int originRow, int originColumn) {
		return this.game.controlErrorsMoveOriginCoordinate(new Coordinate(originRow, originColumn));
	}

	public Error controlErrorsMoveTargetCoordinate(int originRow, int originColumn, int targetRow, int targetColumn) {
		return this.game.controlErrorsMoveTargetCoordinate(new Coordinate(originRow, originColumn),
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
		return this.game.isBoardComplete();
	}

	public void putTokenPlayerFromTurn(int originRow, int originColumn) {
		this.game.putTokenPlayerFromTurn(new Coordinate(originRow, originColumn));
	}

	public void moveTokenPlayerFromTurn(int originRow, int originColumn, int targetRow, int targetColumn) {
		Coordinate[] coordinates = new Coordinate[2];
		coordinates[0] = new Coordinate(originRow, originColumn);
		coordinates[1] = new Coordinate(targetRow, targetColumn);
		this.game.moveTokenPlayerFromTurn(coordinates);
	}

	public void changeTurn() {
		this.game.changeTurn();
	}

	public void continueState() {
		this.state.next();
	}

	public char getTokenChar(int row, int column) {
		return this.game.getToken(row, column).getChar();
	}

	public boolean isEmptyToken(int row, int column) {
		return this.game.getToken(row, column) == null;
	}

	public int getCoordinateDimension() {
		return Coordinate.DIMENSION;
	}

	public boolean isTicTacToe() {
		return this.game.isTicTacToe();
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}
}