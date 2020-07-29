package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Board;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Token;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.tictactoe.views.TokenView;
import usantatecla.utils.WithConsoleModel;

class BoardView extends WithConsoleModel {
    
    Board board;

    BoardView(Board board) {
        this.board = board;
    }

    void write() {
		this.console.writeln(MessageView.SEPARATOR.getMessage());
		for (int i = 0; i < Coordinate.DIMENSION; i++) {
            this.console.write(MessageView.VERTICAL_LINE_LEFT.getMessage());
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				if (this.board.getToken(new Coordinate(i, j)) == null) {
                    this.console.write(MessageView.EMPTY.getMessage());
				} else {
                    Token token = this.board.getToken(new Coordinate(i, j));
                    this.console.write(new TokenView(token).getToken());
				}
                this.console.write(MessageView.VERTICAL_LINE_CENTERED.getMessage());
			}
            this.console.writeln();
        }
        this.console.writeln(MessageView.SEPARATOR.getMessage());
	}
}