package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.View;

public abstract class TicTacToe {

    private Logic logic;
    private View view;

    protected TicTacToe() {
        this.logic = new Logic();
        this.view = this.createView(this.logic);
    }

    protected abstract View createView(Logic logic);

    protected void play() {
        this.view.interact();
    }

}
