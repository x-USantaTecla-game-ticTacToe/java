package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Token;

public abstract class Controller {
    
    protected Game game;

	Controller(Game game) {
		this.game = game;
  }

	public Token getToken(Coordinate coordinate) {
		return this.game.getToken(coordinate);
	}
  
}
