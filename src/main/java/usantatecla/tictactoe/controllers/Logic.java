package usantatecla.tictactoe.controllers;

import java.util.HashMap;
import java.util.Map;

import usantatecla.tictactoe.distributed.dispatchers.TCPIP;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.types.StateValue;

public class Logic {

	private Session session;
	
	private Map<StateValue, AcceptorController> acceptorControllers;

	protected StartController startController;

	protected PlayController playController;

	protected ResultController resultController;
	
	private TCPIP tcpip;

	public Logic(boolean isStandalone) {
		if (isStandalone) {
			this.tcpip = null;
		} else {
			this.tcpip = TCPIP.createClientSocket();
		}
		this.session = new Session(this.tcpip);
		this.acceptorControllers = new HashMap<StateValue, AcceptorController>();
		this.startController = new StartController(this.session, this.tcpip);
		this.acceptorControllers.put(StateValue.INITIAL, this.startController);
		this.playController = new PlayController(this.session, this.tcpip);
		this.acceptorControllers.put(StateValue.IN_GAME, this.playController);
		this.resultController = new ResultController(this.session, this.tcpip);
		this.acceptorControllers.put(StateValue.RESULT, this.resultController);
		this.acceptorControllers.put(StateValue.EXIT, null);
	}
	
	public AcceptorController getController() {
		return this.acceptorControllers.get(this.session.getValueState());
	}
	
	public void close() {
		this.tcpip.close();
	}
    
}