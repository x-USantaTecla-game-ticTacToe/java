package usantatecla.tictactoe;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.View;

public abstract class TicTacToe {

    private Game game;

    private View view;

    protected TicTacToe() {
        this.game = new Game();
        this.view = this.createView(this.game);
    }

    protected abstract View createView(Game game);

    protected void play() {
        this.view.interact();
    }
}
