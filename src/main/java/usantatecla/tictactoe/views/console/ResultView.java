package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.types.Token;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.utils.WithConsoleView;

class ResultView extends WithConsoleView {
    
    Logic logic;
    
    ResultView(Logic logic) {
        this.logic = logic;
    }

    void interact() {
        int otherValue = this.logic.getOtherValueFromTurn();
        this.console.write(Token.values()[otherValue].getChar());
		this.console.writeln(MessageView.PLAYER_WIN.getMessage());
    }
}