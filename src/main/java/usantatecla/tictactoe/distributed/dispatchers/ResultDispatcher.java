package usantatecla.tictactoe.distributed.dispatchers;

import usantatecla.tictactoe.controllers.ResultController;

public class ResultDispatcher extends Dispatcher {

	public ResultDispatcher(ResultController resumeController) {
		super(resumeController);
	}

	@Override
	public void dispatch() {;
		((ResultController)this.acceptorController).finish();
	}

}
