package usantatecla.tictactoe.distributed.dispatchers;

import usantatecla.tictactoe.controllers.StartController;

public class StartDispatcher extends Dispatcher {

	public StartDispatcher(StartController startController) {
		super(startController);
	}

	@Override
	public void dispatch() {
		((StartController) this.acceptorController).start();
	}

}
