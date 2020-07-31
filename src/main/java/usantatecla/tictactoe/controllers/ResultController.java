package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.State;

public class ResultController extends Controller {
   
    public ResultController(Game game, State state) {
		super(game, state);
	}

	public void finish() {
		this.state.next();
	}

	public int getOtherValueFromTurn() {
		return this.game.getOtherValueFromTurn();
	}
}