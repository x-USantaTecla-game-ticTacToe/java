package usantatecla.tictactoe.distributed.dispatchers.errors;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.distributed.dispatchers.Dispatcher;

public class ErrorsPutDispatcher extends Dispatcher {
    
    public ErrorsPutDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
        int row = this.tcpip.receiveInt();
        int column = this.tcpip.receiveInt();
		this.tcpip.send(((PlayController)this.acceptorController).controlErrorsPutCoordinate(row, column));
    }
}