package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;

public class ResultController extends Controller {
   
    public ResultController(Game game) {
		super(game);
	}

	public int getOtherValueFromTurn() {
		return this.game.getOtherValueFromTurn();
	}
}