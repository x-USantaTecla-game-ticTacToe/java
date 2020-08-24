package usantatecla.tictactoe.distributed.dispatchers.save;

import usantatecla.tictactoe.controllers.implementation.PlayControllerImplementation;
import usantatecla.tictactoe.distributed.dispatchers.Dispatcher;

public class NextDispatcher extends Dispatcher {

	public NextDispatcher(PlayControllerImplementation playControllerImplementation) {
		super(playControllerImplementation);
	}

	@Override
	public void dispatch() {
		((PlayControllerImplementation) this.acceptorController).next();
	}

}
