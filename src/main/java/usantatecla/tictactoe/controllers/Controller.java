package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Board;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.State;

public abstract class Controller {
    
	protected Game game;
	
	protected State state;

	Controller(Game game, State state) {
		this.game = game;
		this.state = state;
	}

	public Board getBoard() {
        return this.game.getBoard();
	}
	
	public abstract void accept(ControllersVisitor controllersVisitor);
}