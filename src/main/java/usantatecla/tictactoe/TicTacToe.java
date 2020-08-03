package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.AcceptorController;
import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.View;

public class TicTacToe {

    private Logic logic;

    private View view;

    protected TicTacToe() {
        this.logic = new Logic();
		this.view = new View();
    }

    protected void play() {
		AcceptorController acceptorController;
		do {
			acceptorController = this.logic.getController();
			if (acceptorController != null){
				this.view.interact(acceptorController);
			}
		} while (acceptorController != null); 
	}

    public static void main(String[] args) {
		new TicTacToe().play();
	}
}