package usantatecla.tictactoe.controllers.implementation;

import usantatecla.tictactoe.controllers.ResultController;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.models.SessionImplementation;

public class ResultControllerImplementation extends ResultController {

	public ResultControllerImplementation(Session session) {
		super(session);
	}

	@Override
	public void finish() {
		((SessionImplementation) this.session).next();
	}

	@Override
	public int getOtherValueFromTurn() {
		return ((SessionImplementation) this.session).getOtherValueFromTurn();
	}

	@Override
	public boolean isTicTacToe() {
		return ((SessionImplementation) this.session).isTicTacToe();
	}

}
