package usantatecla.tictactoe.distributed.dispatchers.undoredo;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.distributed.dispatchers.Dispatcher;

public class UndoDispatcher extends Dispatcher {

	public UndoDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		((PlayController)this.acceptorController).undo();
	}

}
