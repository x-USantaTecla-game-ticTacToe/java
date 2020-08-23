package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.models.SessionImplementation;

public class RedoController extends Controller {

    public RedoController(Session session) {
		super(session);
	}

	public void redo() {
		((SessionImplementation) this.session).redo();
	}

	public boolean redoable() {
		return ((SessionImplementation) this.session).redoable();
	}
    
}