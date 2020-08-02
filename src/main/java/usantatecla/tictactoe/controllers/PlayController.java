package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Player;
import usantatecla.tictactoe.models.State;
import usantatecla.tictactoe.types.Token;

public class PlayController extends Controller {
    
    public PlayController(Game game, State state) {
		super(game, state);
	}

	public Player getTokenPlayerFromTurn() {
		return this.game.getTokenPlayerFromTurn();
	}

	public boolean isBoardComplete() {
		return this.game.isBoardComplete();
	}

	public void putTokenPlayerFromTurn(Coordinate coordinate) {
		this.game.putTokenPlayerFromTurn(coordinate);
	}

	public void moveTokenPlayerFromTurn(Coordinate[] coordinates) {
		this.game.moveTokenPlayerFromTurn(coordinates);
	}

	public void changeTurn() {
		this.game.changeTurn();
	}

	public void continueState() {
		this.state.next();
	}

	public Token getToken(int row, int column) {
		return this.game.getToken(row, column);
	}

	public int getCoordinateDimension() {
		return Coordinate.DIMENSION;
	}

	public boolean isTicTacToe() {
		return this.game.isTicTacToe();
	}
}