package usantatecla.tictactoe.distributed.dispatchers.save;

import usantatecla.tictactoe.controllers.implementation.SaveControllerImplementation;
import usantatecla.tictactoe.distributed.dispatchers.Dispatcher;

public class HasNameDispatcher extends Dispatcher {

	public HasNameDispatcher(SaveControllerImplementation saveControllerImplementation) {
		super(saveControllerImplementation);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((SaveControllerImplementation) this.acceptorController).hasName());
	}

}
