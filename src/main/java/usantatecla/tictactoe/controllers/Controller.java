package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;

abstract class Controller {
    
    protected Game game;

	Controller(Game game) {
		this.game = game;
	}
}