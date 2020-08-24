package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.models.SessionImplementation;

public class ExitController extends Controller {

	public ExitController(Session session) {
		super(session);
	}

	public void next() {
		((SessionImplementation) this.session).next();
	}

}
