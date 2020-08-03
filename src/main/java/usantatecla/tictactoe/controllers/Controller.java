package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Board;
import usantatecla.tictactoe.models.Session;

public abstract class Controller {
    
	protected Session session;

	Controller(Session session) {
		this.session = session;
	}
	

	public Board getBoard() {
        return this.session.getBoard();
	}
}