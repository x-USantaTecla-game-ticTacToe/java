package usantatecla.tictactoe.views;

import usantatecla.utils.WithConsoleView;

class ResultView extends WithConsoleView {

    void write(char winner) {
        this.console.write(winner);
		this.console.writeln(MessageView.PLAYER_WIN.getMessage());
    }
}