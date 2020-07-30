package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Board;
import usantatecla.tictactoe.models.Game;

abstract class Controller {
    
    protected Game game;

	Controller(Game game) {
		this.game = game;
	}

	Board getBoard() {
        return this.game.getBoard();
    }
}