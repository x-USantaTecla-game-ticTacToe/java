package usantatecla.tictactoe.distributed.dispatchers;

import usantatecla.tictactoe.controllers.PlayController;

public class BoardCompleteDispatcher extends Dispatcher {

    public BoardCompleteDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayController)this.acceptorController).isBoardComplete());
	}
    
}