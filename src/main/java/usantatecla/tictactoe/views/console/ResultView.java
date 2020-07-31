package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.ResultController;
import usantatecla.tictactoe.types.Token;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.tictactoe.views.TokenView;
import usantatecla.utils.WithConsoleView;

class ResultView extends WithConsoleView {

    void interact(ResultController resultController) {
        resultController.finish();
        int otherValue = resultController.getOtherValueFromTurn();
        this.console.write(new TokenView(Token.values()[otherValue]).getToken());
		this.console.writeln(MessageView.PLAYER_WIN.getMessage());
    }
}