package usantatecla.tictactoe.controllers;

import java.util.HashMap;
import java.util.Map;

import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.types.StateValue;

public class Logic {

	private Session session;
	
	private Map<StateValue, AcceptorController> acceptorControllers;

	public Logic() {
		this.session = new Session();
		this.acceptorControllers = new HashMap<StateValue, AcceptorController>();
		this.acceptorControllers.put(StateValue.INITIAL, new StartController(this.session));
		this.acceptorControllers.put(StateValue.IN_GAME, new PlayController(this.session));
		this.acceptorControllers.put(StateValue.RESUME, new ResumeController(this.session));
		this.acceptorControllers.put(StateValue.EXIT, null);
	}
	
	public AcceptorController getController() {
		return this.acceptorControllers.get(this.session.getValueState());
	}
    
}