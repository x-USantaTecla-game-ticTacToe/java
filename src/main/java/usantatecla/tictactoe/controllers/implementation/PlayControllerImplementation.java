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
	public Error controlErrorsPutCoordinate(int row, int column) {
		return this.movementController.getErrorsPutCoordinate(row, column);
	}

	@Override
	public Error controlErrorsMoveOriginCoordinate(int originRow, int originColumn) {
		return this.movementController.getErrorsMoveOriginCoordinate(originRow, originColumn);
	}

	@Override
	public Error controlErrorsMoveTargetCoordinate(int originRow, int originColumn, int targetRow, int targetColumn) {
		return this.movementController.getErrorsMoveTargetCoordinate(originRow, originColumn, targetRow, targetColumn);
	}

	@Override
	public boolean isCoordinateValid(int row, int column) {
		return this.movementController.isCoordinateValid(row, column);
	}

	@Override
	public int[] generateRandomCoordinate() {
		return this.movementController.generateRandomCoordinate();
	}

	@Override
	public boolean isBoardComplete() {
		return this.movementController.isBoardComplete();
	}

	@Override
	public void putTokenPlayerFromTurn(int originRow, int originColumn) {
		this.movementController.putTokenPlayerFromTurn(originRow, originColumn);
	}

	@Override
	public void moveTokenPlayerFromTurn(int originRow, int originColumn, int targetRow, int targetColumn) {
		this.movementController.moveTokenPlayerFromTurn(originRow, originColumn, targetRow, targetColumn);
	}

	@Override
	public void changeTurn() {
		this.movementController.changeTurn();
	}

	@Override
	public char getTokenChar(int row, int column) {
		return this.movementController.getTokenChar(row, column);
	}

	@Override
	public boolean isEmptyToken(int row, int column) {
		return this.movementController.isEmptyToken(row, column);
	}

	@Override
	public int getCoordinateDimension() {
		return Coordinate.DIMENSION;
	}

	@Override
	public void isTicTacToe() {
		this.movementController.isTicTacToe();
	}

}
