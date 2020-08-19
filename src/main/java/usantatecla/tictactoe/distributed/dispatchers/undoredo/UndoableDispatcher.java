package usantatecla.tictactoe.distributed.dispatchers.undoredo;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.distributed.dispatchers.Dispatcher;

public class UndoableDispatcher extends Dispatcher {

	public UndoableDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayController)this.acceptorController).undoable());
	}

}
