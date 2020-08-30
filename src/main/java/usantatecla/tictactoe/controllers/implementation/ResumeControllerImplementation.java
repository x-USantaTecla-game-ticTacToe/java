package usantatecla.tictactoe.controllers.implementation;

import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.models.SessionImplementation;

public class ResumeControllerImplementation extends ResumeController {

	private SessionImplementation sessionImplementation;

	public ResumeControllerImplementation(Session session) {
		super(session);
		this.sessionImplementation = ((SessionImplementation) this.session);
	}

	public void resume(boolean newGame) {
		if (newGame) {
			this.sessionImplementation.newGame();
		} else {
			this.sessionImplementation.next();
		}
	}

}
