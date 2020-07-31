package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Token;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.tictactoe.views.TokenView;
import usantatecla.utils.WithConsoleView;

class ResultView extends WithConsoleView {
    
    Game game;
    
    ResultView(Game game) {
        this.game = game;
    }

    void interact() {
        int otherValue = this.game.getOtherValueFromTurn();
        this.console.write(new TokenView(Token.values()[otherValue]).getToken());
		this.console.writeln(MessageView.PLAYER_WIN.getMessage());
    }
}