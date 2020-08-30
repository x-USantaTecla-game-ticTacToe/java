package usantatecla.tictactoe.distributed;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.types.StateValue;
import usantatecla.tictactoe.distributed.dispatchers.TCPIP;

public class LogicProxy extends Logic {
	
	private TCPIP tcpip;
	
	public LogicProxy() {
		this.tcpip = TCPIP.createClientSocket();
		this.session = new SessionProxy(this.tcpip);
		this.acceptorControllers.put(StateValue.INITIAL, new StartControllerProxy(this.session, this.tcpip));
		this.acceptorControllers.put(StateValue.IN_GAME, new PlayControllerProxy(this.session, this.tcpip));
		this.acceptorControllers.put(StateValue.SAVING, new SaveControllerProxy(this.session, this.tcpip));
		this.acceptorControllers.put(StateValue.RESUME, new ResumeControllerProxy(this.session, this.tcpip));
		this.acceptorControllers.put(StateValue.EXIT, null);
	}

	public void close() {
		this.tcpip.close();
	}
	
}
