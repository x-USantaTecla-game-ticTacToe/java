package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.distributed.dispatchers.FrameType;
import usantatecla.tictactoe.distributed.dispatchers.TCPIP;
import usantatecla.tictactoe.models.Session;

public class ResultController extends AcceptorController {
   
    public ResultController(Session session, TCPIP tcpip) {
		super(session, tcpip);
	}

	public void finish() {
		if (this.tcpip == null) {
			this.session.next();
		} else {
			this.tcpip.send(FrameType.RESULT.name());
		}
	}

	public int getOtherValueFromTurn() {
		if (this.tcpip == null) {
			return this.session.getOtherValueFromTurn();
		}
		this.tcpip.send(FrameType.OTHER_VALUE_TURN.name());
		return this.tcpip.receiveInt();
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}
}