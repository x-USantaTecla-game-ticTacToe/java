package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Player;

public class PlayController extends Controller {
    
    public PlayController(Game game) {
		super(game);
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

	public boolean isTicTacToe() {
		return this.game.isTicTacToe();
	}
}