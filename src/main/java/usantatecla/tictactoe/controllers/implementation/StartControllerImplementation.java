package usantatecla.tictactoe.controllers.implementation;

import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.models.SessionImplementation;
import usantatecla.tictactoe.models.DAO.SessionImplementationDAO;

public class StartControllerImplementation extends StartController {
	private SessionImplementationDAO sessionImplementationDAO;

	private SessionImplementation sessionImplementation;

	public StartControllerImplementation(Session session, SessionImplementationDAO sessionImplementationDAO) {
		super(session);
		this.sessionImplementationDAO = sessionImplementationDAO;
		this.sessionImplementation = ((SessionImplementation) this.session);
	}

	public void createPlayers(int numberOfUsers) {
		this.sessionImplementation.createPlayers(numberOfUsers);
	}

	@Override
	public void start() {
		this.sessionImplementationDAO.associate(this.sessionImplementation);
		this.sessionImplementation.next();
	}

	@Override
	public void start(String name) {
		this.sessionImplementationDAO.associate(this.sessionImplementation);
		this.sessionImplementationDAO.load(name);
	}

	@Override
	public String[] getGamesNames() {
		return this.sessionImplementationDAO.getGamesNames();
	}

}
