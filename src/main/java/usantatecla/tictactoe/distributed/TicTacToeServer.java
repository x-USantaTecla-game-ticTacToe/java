package usantatecla.tictactoe.distributed;

import usantatecla.tictactoe.distributed.dispatchers.DispatcherPrototype;

public class TicTacToeServer {

	private DispatcherPrototype dispatcherPrototype;

	private LogicServer logic;

	private TicTacToeServer() {
		this.dispatcherPrototype = new DispatcherPrototype();
		this.logic = new LogicServer(true);
		this.logic.createDispatchers(this.dispatcherPrototype);
	}

	private void serve() {
		this.dispatcherPrototype.serve();
	}

	public static void main(String[] args) {
		new TicTacToeServer().serve();
	}

}
