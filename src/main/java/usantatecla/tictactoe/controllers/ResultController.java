package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Session;

public class ResultController extends AcceptorController {
   
    public ResultController(Session session) {
		super(session);
	}

	public void finish() {
		this.session.next();
	}

	public int getOtherValueFromTurn() {
		return this.session.getOtherValueFromTurn();
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}
}