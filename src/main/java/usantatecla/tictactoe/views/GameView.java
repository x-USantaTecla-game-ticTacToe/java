package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.PlayController;

public class GameView {

    GameView(PlayController playController) {
        playController.changeTurn();
        new BoardView(playController).write();
        playController.isTicTacToe();
    }
    
}