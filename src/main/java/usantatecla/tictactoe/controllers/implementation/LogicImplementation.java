package usantatecla.tictactoe.controllers.implementation;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.models.SessionImplementation;
import usantatecla.tictactoe.types.StateValue;

public class LogicImplementation extends Logic {

	protected StartControllerImplementation startControllerImplementation;

	protected PlayControllerImplementation playControllerImplementation;

	protected ResultControllerImplementation resultControllerImplementation;

	public LogicImplementation() {
		this.session = new SessionImplementation();
		this.startControllerImplementation = new StartControllerImplementation(this.session);
		this.playControllerImplementation = new PlayControllerImplementation(this.session);
		this.resultControllerImplementation = new ResultControllerImplementation(this.session);
		this.acceptorControllers.put(StateValue.INITIAL, this.startControllerImplementation);
		this.acceptorControllers.put(StateValue.IN_GAME, this.playControllerImplementation);
		this.acceptorControllers.put(StateValue.RESULT, this.resultControllerImplementation);
		this.acceptorControllers.put(StateValue.EXIT, null);
	}

}
