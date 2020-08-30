package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.controllers.implementation.LogicImplementation;
import usantatecla.tictactoe.models.DAO.SessionImplementationDAO;

public class TicTacToeStandalone extends TicTacToe {

    @Override
	protected Logic createLogic() {
		return new LogicImplementation(new SessionImplementationDAO());
	}
	
	public static void main(String[] args) {
		new TicTacToeStandalone().play();
	}
    
}