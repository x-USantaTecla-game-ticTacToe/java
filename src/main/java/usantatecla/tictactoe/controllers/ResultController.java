package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;

class ResultController extends Controller {
   
    ResultController(Game game) {
		super(game);
	}

	int getOtherValueFromTurn() {
		return this.game.getOtherValueFromTurn();
	}
}