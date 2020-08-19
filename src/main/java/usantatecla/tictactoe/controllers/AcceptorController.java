package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.distributed.dispatchers.TCPIP;
import usantatecla.tictactoe.models.Session;

public abstract class AcceptorController extends Controller {

	protected TCPIP tcpip;
    
    AcceptorController(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	public abstract void accept(ControllersVisitor controllersVisitor);
}