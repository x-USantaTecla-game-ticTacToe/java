package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.controllers.implementation.LogicImplementation;
import usantatecla.tictactoe.models.DAO.SessionImplementationDAO;

public abstract class TicTacToeStandalone extends TicTacToe {

    @Override
	protected Logic createLogic() {
		return new LogicImplementation(this.createDAO());
	}

	protected abstract SessionImplementationDAO createDAO();
    
}