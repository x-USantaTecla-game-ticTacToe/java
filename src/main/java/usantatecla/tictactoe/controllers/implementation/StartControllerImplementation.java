package usantatecla.tictactoe.controllers.implementation;

import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.models.SessionImplementation;
import usantatecla.tictactoe.models.DAO.SessionImplementationDAO;

public class StartControllerImplementation extends StartController {
	private SessionImplementationDAO sessionImplementationDAO;

	public StartControllerImplementation(Session session, SessionImplementationDAO sessionImplementationDAO) {
		super(session);
		this.sessionImplementationDAO = sessionImplementationDAO;
	}

	public void createPlayers(int numberOfUsers) {
		((SessionImplementation) this.session).createPlayers(numberOfUsers);
	}

	@Override
	public void start() {
		this.sessionImplementationDAO.associate((SessionImplementation)this.session);
		((SessionImplementation) this.session).next();		
	}

	@Override
	public void start(String name) {
		this.sessionImplementationDAO.load(name);
	}

	@Override
	public String[] getGamesNames() {
		return this.sessionImplementationDAO.getGamesNames();
	}

}
