package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;

public class StartController extends Controller {
    
    public StartController(Game game) {
		super(game);
	}

	public void createPlayers(int numberOfUsers) {
		this.game.createPlayers(numberOfUsers);
	}
}