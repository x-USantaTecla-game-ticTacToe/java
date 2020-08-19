package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Board;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.types.StateValue;

public abstract class Controller {
    
	protected Session session;

	Controller(Session session) {
		this.session = session;
	}

	public Board getBoard() {
        return this.session.getBoard();
	}

	public StateValue getValueState() {
		return this.session.getValueState();
	}
}