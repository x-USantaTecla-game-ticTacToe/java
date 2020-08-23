package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.AcceptorController;
import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.View;

public abstract class TicTacToe {

    private Logic logic;

    private View view;

    protected TicTacToe() {
        this.logic = this.createLogic();
		this.view = new View();
	}
	
	protected abstract Logic createLogic();

    protected void play() {
		AcceptorController acceptorController;
		do {
			acceptorController = this.logic.getController();
			if (acceptorController != null){
				this.view.interact(acceptorController);
			}
		} while (acceptorController != null);
	}
}