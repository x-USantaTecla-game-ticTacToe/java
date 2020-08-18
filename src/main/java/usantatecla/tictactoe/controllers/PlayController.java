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

	public Error getErrorsPutCoordinate(int row, int column) {
		return this.movementController.getErrorsPutCoordinate(row, column);
	}

	public Error getErrorsMoveOriginCoordinate(int originRow, int originColumn) {
		return this.movementController.getErrorsMoveOriginCoordinate(originRow, originColumn);
	}

	public Error getErrorsMoveTargetCoordinate(int originRow, int originColumn, int targetRow, int targetColumn) {
		return this.movementController.getErrorsMoveTargetCoordinate(originRow, originColumn, targetRow, targetColumn);
	}

	public boolean isCoordinateValid(int row, int column) {
		return this.movementController.isCoordinateValid(row, column);
	}

	public int[] generateRandomCoordinate() {
		return this.movementController.generateRandomCoordinate();
	}

	public boolean isBoardComplete() {
		return this.movementController.isBoardComplete();
	}

	public void putTokenPlayerFromTurn(int originRow, int originColumn) {
		this.movementController.putTokenPlayerFromTurn(originRow, originColumn);
	}

	public void moveTokenPlayerFromTurn(int originRow, int originColumn, int targetRow, int targetColumn) {
		this.movementController.moveTokenPlayerFromTurn(originRow, originColumn, targetRow, targetColumn);
	}

	public void changeTurn() {
		this.movementController.changeTurn();
	}

	public char getTokenChar(int row, int column) {
		return this.movementController.getTokenChar(row, column);
	}

	public boolean isEmptyToken(int row, int column) {
		return this.movementController.isEmptyToken(row, column);
	}

	public int getCoordinateDimension() {
		return Coordinate.DIMENSION;
	}

	public void isTicTacToe() {
		this.movementController.isTicTacToe();
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}
}