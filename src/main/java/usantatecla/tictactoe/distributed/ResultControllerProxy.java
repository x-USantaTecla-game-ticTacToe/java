package usantatecla.tictactoe.distributed;

import usantatecla.tictactoe.controllers.ResultController;
import usantatecla.tictactoe.distributed.dispatchers.FrameType;
import usantatecla.tictactoe.models.Session;
import usantatecla.utils.TCPIP;

public class ResultControllerProxy extends ResultController {
	
	private TCPIP tcpip;

	public ResultControllerProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	@Override
	public void finish() {
		this.tcpip.send(FrameType.RESULT.name());
	}

	@Override
	public int getOtherValueFromTurn() {
		this.tcpip.send(FrameType.OTHER_VALUE_TURN.name());
		return this.tcpip.receiveInt();
	}

}
