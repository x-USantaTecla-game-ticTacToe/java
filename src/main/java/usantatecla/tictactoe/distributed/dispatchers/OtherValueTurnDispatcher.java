package usantatecla.tictactoe.distributed.dispatchers;

import usantatecla.tictactoe.controllers.ResultController;

public class OtherValueTurnDispatcher extends Dispatcher {

    public OtherValueTurnDispatcher(ResultController resultController) {
		super(resultController);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((ResultController) this.acceptorController).getOtherValueFromTurn());
	}
    
}