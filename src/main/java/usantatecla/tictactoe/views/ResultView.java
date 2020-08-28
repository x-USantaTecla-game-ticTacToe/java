package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Token;
import usantatecla.utils.WithConsoleView;

class ResultView extends WithConsoleView {

    void writeln(int winner) {
        new TokenView(Token.values()[winner]).write();
		MessageView.PLAYER_WIN.writeln();
    }
}