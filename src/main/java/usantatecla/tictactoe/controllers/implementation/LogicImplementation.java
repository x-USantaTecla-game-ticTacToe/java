package usantatecla.tictactoe.controllers.implementation;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.models.SessionImplementation;
import usantatecla.tictactoe.models.DAO.SessionImplementationDAO;
import usantatecla.tictactoe.types.StateValue;

public class LogicImplementation extends Logic {

	protected SessionImplementationDAO sessionImplementationDAO;

	protected StartControllerImplementation startControllerImplementation;

	protected PlayControllerImplementation playControllerImplementation;

	protected SaveControllerImplementation saveControllerImplementation;

	protected ResultControllerImplementation resultControllerImplementation;

	public LogicImplementation(SessionImplementationDAO sessionImplementationDAO) {
		this.session = new SessionImplementation();
		this.sessionImplementationDAO = sessionImplementationDAO;
		this.sessionImplementationDAO.associate((SessionImplementation) this.session);
		this.startControllerImplementation = new StartControllerImplementation(this.session, this.sessionImplementationDAO);
		this.playControllerImplementation = new PlayControllerImplementation(this.session);
		this.saveControllerImplementation = new SaveControllerImplementation(this.session, this.sessionImplementationDAO);
		this.resultControllerImplementation = new ResultControllerImplementation(this.session);
		this.acceptorControllers.put(StateValue.INITIAL, this.startControllerImplementation);
		this.acceptorControllers.put(StateValue.IN_GAME, this.playControllerImplementation);
		this.acceptorControllers.put(StateValue.SAVING, this.saveControllerImplementation);
		this.acceptorControllers.put(StateValue.RESULT, this.resultControllerImplementation);
		this.acceptorControllers.put(StateValue.EXIT, null);
	}

}
