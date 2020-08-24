package usantatecla.tictactoe.controllers.implementation;

import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.models.SessionImplementation;

public class StartControllerImplementation extends StartController {

	public StartControllerImplementation(Session session) {
		super(session);
	}

	public void createPlayers(int numberOfUsers) {
		((SessionImplementation) this.session).createPlayers(numberOfUsers);
	}

	@Override
	public void start() {
		((SessionImplementation) this.session).next();		
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
