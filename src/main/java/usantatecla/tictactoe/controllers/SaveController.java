package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Session;

public abstract class SaveController extends AcceptorController {

	public SaveController(Session session) {
		super(session);
	}

	public abstract void save(String name);

	public abstract void save();

	public abstract void next();

	public abstract boolean hasName();

	public abstract boolean exists(String readString);

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
