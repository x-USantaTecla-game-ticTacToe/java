package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResultController;
import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.View;

public abstract class TicTacToe {

    private Game game;

    private StartController startController;

    private PlayController playController;

    private ResultController resultController;

    private View view;

    protected TicTacToe() {
        this.game = new Game();
        this.startController = new StartController(this.game);
        this.playController = new PlayController(this.game);
        this.resultController = new ResultController(this.game);
        this.view = this.createView(this.startController, this.playController, this.resultController);
    }

    protected abstract View createView(StartController startController, PlayController playController,
            ResultController resultController);

    protected void play() {
        this.view.interact();
    }
}