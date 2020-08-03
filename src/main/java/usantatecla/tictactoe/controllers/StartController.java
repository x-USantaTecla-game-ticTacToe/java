package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Session;

public class StartController extends AcceptorController {
    
    public StartController(Session session) {
		super(session);
	}

	public void start() {
		this.session.next();
	}

	public void createPlayers(int numberOfUsers) {
		this.session.createPlayers(numberOfUsers);
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}
}