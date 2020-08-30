package usantatecla.tictactoe.controllers.implementation;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ExitController;
import usantatecla.tictactoe.controllers.MovementController;
import usantatecla.tictactoe.controllers.RedoController;
import usantatecla.tictactoe.controllers.UndoController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.PlayerType;

public class PlayControllerImplementation extends PlayController {

	private MovementController movementController;

	private UndoController undoController;

	private RedoController redoController;
	
	private ExitController exitController;

	public PlayControllerImplementation(Session session) {
		super(session);
		this.movementController = new MovementController(this.session);
		this.undoController = new UndoController(this.session);
		this.redoController = new RedoController(this.session);
		this.exitController = new ExitController(this.session);
	}

	@Override
	public void undo() {
		this.undoController.undo();
	}

	@Override
	public void redo() {
		this.redoController.redo();
	}

	@Override
	public void next() {
		this.exitController.next();
	}

	@Override
	public boolean undoable() {
		return this.undoController.undoable();
	}

	@Override
	public boolean redoable() {
		return this.redoController.redoable();
	}

	@Override
	public PlayerType getTypeOfTokenPlayerFromTurn() {
		return this.movementController.getTypeOfTokenPlayerFromTurn();
	}

	@Override
	public Error getPutCoordinateError(Coordinate coordinate) {
		return this.movementController.getPutCoordinateError(coordinate);
	}

	@Override
	public Error getMoveOriginCoordinateError(Coordinate coordinate) {
		return this.movementController.getMoveOriginCoordinateError(coordinate);
	}

	@Override
	public Error getMoveTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
		return this.movementController.getMoveTargetCoordinateError(originCoordinate, targetCoordinate);
	}

	@Override
	public boolean isCoordinateValid(Coordinate coordinate) {
		return this.movementController.isCoordinateValid(coordinate);
	}

	@Override
	public Coordinate generateRandomCoordinate() {
		return this.movementController.generateRandomCoordinate();
	}

	@Override
	public boolean isBoardComplete() {
		return this.movementController.isBoardComplete();
	}

	@Override
	public void putTokenPlayerFromTurn(Coordinate coordinate) {
		this.movementController.putTokenPlayerFromTurn(coordinate);
	}

	@Override
	public void moveTokenPlayerFromTurn(Coordinate[] coordinates) {
		this.movementController.moveTokenPlayerFromTurn(coordinates);
	}

	@Override
	public void changeTurn() {
		this.movementController.changeTurn();
	}

	@Override
	public char getTokenChar(Coordinate coordinate) {
		return this.movementController.getTokenChar(coordinate);
	}

	@Override
	public boolean isEmptyToken(Coordinate coordinate) {
		return this.movementController.isEmptyToken(coordinate);
	}

	@Override
	public int getValueFromTurn() {
		return this.movementController.getValueFromTurn();
	}

	@Override
	public int getCoordinateDimension() {
		return Coordinate.DIMENSION;
	}

	@Override
	public void continueState() {
		this.movementController.continueState();
	}

	@Override
	public boolean isTicTacToe() {
		return this.movementController.isTicTacToe();
	}

}
