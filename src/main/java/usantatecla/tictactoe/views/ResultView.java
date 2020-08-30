package usantatecla.tictactoe.views;

import usantatecla.tictactoe.types.Token;
import usantatecla.utils.WithConsoleView;

class ResultView extends WithConsoleView {

    void writeln(int winner) {
        this.console.write(Token.values()[winner].getChar());
		this.console.writeln(MessageView.PLAYER_WIN.getMessage());
    }
}