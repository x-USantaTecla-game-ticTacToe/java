package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.PlayerType;

public abstract class PlayController extends AcceptorController {
    
    public PlayController(Session session) {
		super(session);
	}

	public abstract void undo();

	public abstract void redo();

	public abstract boolean undoable();

	public abstract boolean redoable();

	public abstract PlayerType getTypeOfTokenPlayerFromTurn();

	public abstract Error getPutCoordinateError(Coordinate coordinate);

	public abstract Error getMoveOriginCoordinateError(Coordinate coordinate);

	public abstract Error getMoveTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate);

	public abstract boolean isCoordinateValid(Coordinate coordinate);

	public abstract Coordinate generateRandomCoordinate();

	public abstract boolean isBoardComplete();

	public abstract void putTokenPlayerFromTurn(Coordinate coordinate);

	public abstract void moveTokenPlayerFromTurn(Coordinate[] coordinates);

	public abstract void changeTurn();

	public abstract char getTokenChar(Coordinate coordinate);

	public abstract boolean isEmptyToken(Coordinate coordinate);

	public abstract int getCoordinateDimension();

	public abstract int getValueFromTurn();

	public abstract boolean isTicTacToe();
	
	public abstract void continueState();

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}
}