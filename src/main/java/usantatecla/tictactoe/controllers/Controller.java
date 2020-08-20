package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;

public abstract class Controller {
    
    protected Game game;

	Controller(Game game) {
		this.game = game;
	}
}