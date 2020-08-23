package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.models.SessionImplementation;

public class UndoController extends Controller {

    public UndoController(Session session) {
		super(session);
	}

	public void undo() {
		((SessionImplementation) this.session).undo();
	}

	public boolean undoable() {
		return ((SessionImplementation) this.session).undoable();
	}
    
}