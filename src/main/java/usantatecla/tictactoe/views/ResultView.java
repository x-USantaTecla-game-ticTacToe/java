package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Token;
import usantatecla.utils.WithConsoleModel;

class ResultView extends WithConsoleModel {
    
    Game game;
    
    ResultView(Game game) {
        this.game = game;
    }

    void interact() {
        int otherValue = this.game.getOtherValueFromTurn();
        new TokenView(Token.values()[otherValue]).write();
		MessageView.PLAYER_WIN.writeln();
    }
}