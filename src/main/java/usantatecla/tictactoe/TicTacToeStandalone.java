package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.controllers.implementation.LogicImplementation;

public class TicTacToeStandalone extends TicTacToe {

    @Override
	protected Logic createLogic() {
		return new LogicImplementation();
	}
	
	public static void main(String[] args) {
		new TicTacToeStandalone().play();
	}
    
}