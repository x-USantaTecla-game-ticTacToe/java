package usantatecla.tictactoe.controllers.implementation;

import usantatecla.tictactoe.controllers.SaveController;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.models.SessionImplementation;
import usantatecla.tictactoe.models.DAO.SessionImplementationDAO;

public class SaveControllerImplementation extends SaveController {

	private SessionImplementationDAO sessionImplementationDAO;

	SaveControllerImplementation(Session session, SessionImplementationDAO sessionImplementationDAO) {
		super(session);
		this.sessionImplementationDAO = sessionImplementationDAO;
	}

	@Override
	public void save(String name) {
		this.sessionImplementationDAO.save(name);
	}

	@Override
	public void save() {
		this.sessionImplementationDAO.save();
	}

	@Override
	public void next() {
		((SessionImplementation) this.session).next();
	}

	@Override
	public boolean hasName() {
		return ((SessionImplementation) this.session).hasName();
	}

	@Override
	public boolean exists(String name) {
		return this.sessionImplementationDAO.exists(name);
	}

}
