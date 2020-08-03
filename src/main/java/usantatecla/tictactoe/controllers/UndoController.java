package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Session;

public class UndoController extends Controller {

    UndoController(Session session) {
		super(session);
	}

	void undo() {
		this.session.undo();
	}

	boolean undoable() {
		return this.session.undoable();
	}
    
}