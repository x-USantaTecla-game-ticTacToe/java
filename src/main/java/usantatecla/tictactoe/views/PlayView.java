package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;

public class PlayView {

    Game game;
    
    PlayView(Game game) {
        this.game = game;
    }

    boolean interact() {
        if (!this.game.isBoardComplete()) {
            this.game.putTokenPlayerFromTurn();
        } else {
            this.game.moveTokenPlayerFromTurn();
        }
        this.game.changeTurn();
        new BoardView(this.game.getBoard()).write();
        return this.game.isTicTacToe();
    }
}