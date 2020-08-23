package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Session;

public abstract class ResultController extends AcceptorController {
   
    public ResultController(Session session) {
		super(session);
	}

	public abstract void finish();

	public abstract int getOtherValueFromTurn();

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}
}