package usantatecla.tictactoe.distributed.dispatchers.save;

import usantatecla.tictactoe.controllers.implementation.SaveControllerImplementation;
import usantatecla.tictactoe.distributed.dispatchers.Dispatcher;

public class SaveDispatcher extends Dispatcher {

	public SaveDispatcher(SaveControllerImplementation saveControllerImplementation) {
		super(saveControllerImplementation);
	}

	@Override
	public void dispatch() {
		String name = this.tcpip.receiveLine();
		((SaveControllerImplementation) this.acceptorController).save(name);
	}

}
