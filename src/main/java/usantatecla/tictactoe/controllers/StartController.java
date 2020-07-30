package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
class StartController extends Controller {
    
    StartController(Game game) {
		super(game);
	}

	void createPlayers(int numberOfUsers) {
		this.game.createPlayers(numberOfUsers);
	}
}