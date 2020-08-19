package usantatecla.tictactoe.distributed.dispatchers;

import usantatecla.tictactoe.controllers.PlayController;

public class MoveTokenDispatcher extends Dispatcher {

	public MoveTokenDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		int originRow = this.tcpip.receiveInt();
		int originColumn = this.tcpip.receiveInt();
		int targetRow = this.tcpip.receiveInt();
		int targetColumn = this.tcpip.receiveInt();
		((PlayController) this.acceptorController).moveTokenPlayerFromTurn(originRow, originColumn, targetRow,
				targetColumn);
	}
}