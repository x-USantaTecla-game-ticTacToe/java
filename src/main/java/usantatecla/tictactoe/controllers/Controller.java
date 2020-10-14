package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.State;
import usantatecla.tictactoe.models.Token;

public abstract class Controller {

	protected Game game;
	protected State state;

	Controller(Game game, State state) {
		this.game = game;
		this.state = state;
	}

	public Token getToken(Coordinate coordinate) {
		return this.game.getToken(coordinate);
	}

	public void next() {
		this.state.next();
	}

}
