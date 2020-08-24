package usantatecla.tictactoe.distributed.dispatchers.save;

import usantatecla.tictactoe.controllers.implementation.SaveControllerImplementation;
import usantatecla.tictactoe.distributed.dispatchers.Dispatcher;

public class SaveNamedDispatcher extends Dispatcher {

	public SaveNamedDispatcher(SaveControllerImplementation saveControllerImplementation) {
		super(saveControllerImplementation);
	}

	@Override
	public void dispatch() {
		((SaveControllerImplementation) this.acceptorController).save();
	}

}
