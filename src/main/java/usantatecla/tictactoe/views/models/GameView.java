package usantatecla.tictactoe.views.models;

import usantatecla.tictactoe.controllers.PlayController;

public class GameView {

    public GameView(PlayController playController) {
        new BoardView(playController).write();
        playController.isTicTacToe();
    }
    
}