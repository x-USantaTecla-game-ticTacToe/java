package usantatecla.tictactoe.controllers.implementation;

import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.models.SessionImplementation;

public class StartControllerImplementation extends StartController {

	SessionImplementation sessionImplementation;

	public StartControllerImplementation(Session session) {
		super(session);
		this.sessionImplementation = ((SessionImplementation) this.session);
	}

	public void createPlayers(int numberOfUsers) {
		this.sessionImplementation.createPlayers(numberOfUsers);
	}

	@Override
	public void start() {
		this.sessionImplementation.next();		
	}

	@Override
	public void start(String name) {
		((SessionImplementation) this.session).load(name);
	}

	@Override
	public String[] getGamesNames() {
		return ((SessionImplementation) this.session).getGamesNames();
	}

}
