package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Token;

class ResultView {
    
    Game game;
    
    ResultView(Game game) {
        this.game = game;
    }

    void interact() {
        int otherValue = this.game.getOtherValueFromTurn();
        new GameView(this.game).writeWin(Token.values()[otherValue]);
    }
}