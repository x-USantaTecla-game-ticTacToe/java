package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Player;
import usantatecla.tictactoe.types.Token;

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

	Token getToken(int row, int column) {
		return this.game.getToken(row, column);
	}

	int getCoordinateDimension() {
		return Coordinate.DIMENSION;
	}

	boolean isTicTacToe() {
		return this.game.isTicTacToe();
	}
}