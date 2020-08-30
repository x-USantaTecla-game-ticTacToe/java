package usantatecla.tictactoe.distributed.dispatchers;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;

public class EmptyTokenDispatcher extends Dispatcher {
    
    public EmptyTokenDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
        int row = this.tcpip.receiveInt();
        int column = this.tcpip.receiveInt();
		this.tcpip.send(((PlayController)this.acceptorController).isEmptyToken(new Coordinate(row, column)));
    }
}