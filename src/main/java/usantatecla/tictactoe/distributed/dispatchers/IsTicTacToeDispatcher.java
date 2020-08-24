package usantatecla.tictactoe.distributed.dispatchers;

import usantatecla.tictactoe.controllers.ResultController;

public class IsTicTacToeDispatcher extends Dispatcher {
    
    public IsTicTacToeDispatcher(ResultController resultController) {
		super(resultController);
	}

	@Override
	public void dispatch() {
		((ResultController)this.acceptorController).isTicTacToe();
	}
}