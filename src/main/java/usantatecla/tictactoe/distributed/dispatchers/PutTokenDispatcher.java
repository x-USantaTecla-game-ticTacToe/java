package usantatecla.tictactoe.distributed.dispatchers;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;

public class PutTokenDispatcher extends Dispatcher {
    
    public PutTokenDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
        int row = this.tcpip.receiveInt();
        int column = this.tcpip.receiveInt();
		((PlayController)this.acceptorController).putTokenPlayerFromTurn(new Coordinate(row, column));
	}
}