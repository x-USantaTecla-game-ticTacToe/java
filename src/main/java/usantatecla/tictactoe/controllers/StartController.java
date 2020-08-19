package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.distributed.dispatchers.FrameType;
import usantatecla.tictactoe.distributed.dispatchers.TCPIP;
import usantatecla.tictactoe.models.Session;

public class StartController extends AcceptorController {
    
    public StartController(Session session, TCPIP tcpip) {
		super(session, tcpip);
	}

	public void start() {
		if (this.tcpip == null) {
			this.session.next();	
		} else {
			this.tcpip.send(FrameType.START.name());
		}
	}

	public void createPlayers(int numberOfUsers) {
		if (this.tcpip == null) {
			this.session.createPlayers(numberOfUsers);	
		} else {
			this.tcpip.send(FrameType.CREATE_PLAYERS.name());
			this.tcpip.send(numberOfUsers);
		}
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}
}