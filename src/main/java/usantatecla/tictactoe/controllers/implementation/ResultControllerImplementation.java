package usantatecla.tictactoe.controllers.implementation;

import usantatecla.tictactoe.controllers.ResultController;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.models.SessionImplementation;

public class ResultControllerImplementation extends ResultController {

	public ResultControllerImplementation(Session session) {
		super(session);
	}

	public void finish() {
		((SessionImplementation) this.session).next();
	}

	public int getOtherValueFromTurn() {
		return ((SessionImplementation) this.session).getOtherValueFromTurn();
	}

}
