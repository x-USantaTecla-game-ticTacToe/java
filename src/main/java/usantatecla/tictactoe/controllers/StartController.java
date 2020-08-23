package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Session;

public abstract class StartController extends AcceptorController {
    
    public StartController(Session session) {
		super(session);
	}

	public abstract void start();

	public abstract void createPlayers(int numberOfUsers);

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}
}