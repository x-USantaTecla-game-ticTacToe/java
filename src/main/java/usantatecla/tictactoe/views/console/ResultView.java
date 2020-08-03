package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Token;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.utils.WithConsoleView;

class ResultView extends WithConsoleView {
    
    Game game;
    
    ResultView(Game game) {
        this.game = game;
    }

    void interact() {
        int otherValue = this.game.getOtherValueFromTurn();
        this.console.write(Token.values()[otherValue].getChar());
		this.console.writeln(MessageView.PLAYER_WIN.getMessage());
    }
}