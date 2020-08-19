package usantatecla.tictactoe.distributed.dispatchers;

import usantatecla.tictactoe.controllers.PlayController;

public class PlayerTypeDispatcher extends Dispatcher {

    public PlayerTypeDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayController)this.acceptorController).getTypeOfTokenPlayerFromTurn());
	}
    
}