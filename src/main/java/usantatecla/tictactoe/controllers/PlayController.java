package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Player;

class PlayController extends Controller {
    
    PlayController(Game game) {
		super(game);
	}

	Player getTokenPlayerFromTurn() {
		return this.game.getTokenPlayerFromTurn();
	}

	boolean isBoardComplete() {
		return this.game.isBoardComplete();
	}

	void putTokenPlayerFromTurn(Coordinate coordinate) {
		this.game.putTokenPlayerFromTurn(coordinate);
	}

	void moveTokenPlayerFromTurn(Coordinate[] coordinates) {
		this.game.moveTokenPlayerFromTurn(coordinates);
	}

	void changeTurn() {
		this.game.changeTurn();
	}

	boolean isTicTacToe() {
		return this.game.isTicTacToe();
	}
}