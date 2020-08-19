package usantatecla.tictactoe.distributed.dispatchers.undoredo;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.distributed.dispatchers.Dispatcher;

public class RedoDispatcher extends Dispatcher {

	public RedoDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		((PlayController)this.acceptorController).redo();
	}

}
