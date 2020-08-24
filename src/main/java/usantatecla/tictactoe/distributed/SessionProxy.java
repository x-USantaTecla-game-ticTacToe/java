package usantatecla.tictactoe.distributed;

import usantatecla.tictactoe.distributed.dispatchers.FrameType;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.types.StateValue;
import usantatecla.utils.TCPIP;

public class SessionProxy implements Session {
	
	private TCPIP tcpip;

	public SessionProxy(TCPIP tcpip) {
		this.tcpip = tcpip;
	}
	
	public StateValue getValueState() {
		this.tcpip.send(FrameType.STATE.name());
		return StateValue.values()[this.tcpip.receiveInt()];
	}

}
