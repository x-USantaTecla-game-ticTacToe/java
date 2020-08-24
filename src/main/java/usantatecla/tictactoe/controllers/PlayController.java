package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.PlayerType;

public abstract class PlayController extends AcceptorController {
    
    public PlayController(Session session) {
		super(session);
	}

	public abstract void undo();

	public abstract void redo();

	public abstract void next();

	public abstract boolean undoable();

	public abstract boolean redoable();

	public abstract PlayerType getTypeOfTokenPlayerFromTurn();

	public abstract Error controlErrorsPutCoordinate(int row, int column);

	public abstract Error controlErrorsMoveOriginCoordinate(int originRow, int originColumn);

	public abstract Error controlErrorsMoveTargetCoordinate(int originRow, int originColumn, int targetRow, int targetColumn);

	public abstract boolean isCoordinateValid(int row, int column);

	public abstract int[] generateRandomCoordinate();

	public abstract boolean isBoardComplete();

	public abstract void putTokenPlayerFromTurn(int originRow, int originColumn);

	public abstract void moveTokenPlayerFromTurn(int originRow, int originColumn, int targetRow, int targetColumn);

	public abstract void changeTurn();

	public abstract char getTokenChar(int row, int column);

	public abstract boolean isEmptyToken(int row, int column);

	public abstract int getCoordinateDimension();

	public abstract void isTicTacToe();

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}
}