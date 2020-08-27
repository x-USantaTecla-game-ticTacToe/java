package usantatecla.tictactoe.distributed;

import usantatecla.tictactoe.distributed.dispatchers.DispatcherPrototype;
import usantatecla.tictactoe.models.DAO.SessionImplementationDAO;

public abstract class TicTacToeServer {

	private DispatcherPrototype dispatcherPrototype;

	private LogicImplementationServer logic;

	protected TicTacToeServer() {
		this.dispatcherPrototype = new DispatcherPrototype();
		this.logic = new LogicImplementationServer(this.createDAO());
		this.logic.createDispatchers(this.dispatcherPrototype);
	}

	protected void serve() {
		this.dispatcherPrototype.serve();
	}

	protected abstract SessionImplementationDAO createDAO();

}
