package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.ResultController;
import usantatecla.tictactoe.types.Token;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.utils.WithConsoleView;

class ResultView extends WithConsoleView {

    void interact(ResultController resultController) {
        resultController.finish();
        int otherValue = resultController.getOtherValueFromTurn();
        this.console.write(Token.values()[otherValue].getChar());
		this.console.writeln(MessageView.PLAYER_WIN.getMessage());
    }
}