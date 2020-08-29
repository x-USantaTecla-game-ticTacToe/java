package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.PlayerType;

public class PlayController extends AcceptorController {

	private MovementController movementController;

	private UndoController undoController;

	private RedoController redoController;
    
    public PlayController(Session session) {
		super(session);
		this.movementController = new MovementController(this.session);
		this.undoController = new UndoController(this.session);
		this.redoController = new RedoController(this.session);
	}

	public void undo() {
		this.undoController.undo();
	}

	public void redo() {
		this.redoController.redo();
	}

	public boolean undoable() {
		return this.undoController.undoable();
	}

	public boolean redoable() {
		return this.redoController.redoable();
	}

	public PlayerType getTypeOfTokenPlayerFromTurn() {
		return this.movementController.getTypeOfTokenPlayerFromTurn();
	}

	public Error getPutCoordinateError(Coordinate coordinate) {
		return this.movementController.getPutCoordinateError(coordinate);
	}

	public Error getMoveOriginCoordinateError(Coordinate originCoordinate) {
		return this.movementController.getMoveOriginCoordinateError(originCoordinate);
	}

	public Error getMoveTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
		return this.movementController.getMoveTargetCoordinateError(originCoordinate, targetCoordinate);
	}

	public boolean isCoordinateValid(Coordinate coordinate) {
		return coordinate.isValid();
	}

	public Coordinate generateRandomCoordinate() {
		Coordinate coordinateRandom = new Coordinate();
		coordinateRandom.random();
		return coordinateRandom;
	}

	public boolean isBoardComplete() {
		return this.movementController.isBoardComplete();
	}

	public void putTokenPlayerFromTurn(Coordinate coordinate) {
		this.movementController.putTokenPlayerFromTurn(coordinate);
	}

	public void moveTokenPlayerFromTurn(Coordinate originCoordinate, Coordinate targetCoordinate) {
		Coordinate[] coordinates = new Coordinate[2];
		coordinates[0] = originCoordinate;
		coordinates[1] = targetCoordinate;
		this.movementController.moveTokenPlayerFromTurn(coordinates);
	}

	public void changeTurn() {
		this.movementController.changeTurn();
	}

	public char getTokenChar(Coordinate coordinate) {
		return this.movementController.getTokenChar(coordinate);
	}

	public boolean isEmptyToken(Coordinate coordinate) {
		return this.movementController.isEmptyToken(coordinate);
	}

	public int getCoordinateDimension() {
		return Coordinate.DIMENSION;
	}

	public int getValueFromTurn() {
        return this.movementController.getValueFromTurn();
    }

	public boolean isTicTacToe() {
		return this.movementController.isTicTacToe();
	}

	public void continueState() {
		this.movementController.continueState();
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}
}