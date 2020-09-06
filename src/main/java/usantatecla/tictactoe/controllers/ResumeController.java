package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.views.ResumeView;

public class ResumeController extends Controller {

	public ResumeController(Session session) {
		super(session);
	}

	private void resume(boolean newGame) {
		if (newGame) {
			this.session.newGame();
		} else {
			this.session.next();
		}
	}

	@Override
	public void control() {
		this.resume(new ResumeView().read());
	}

}
