package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Board;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Token;

class BoardView {
    
    Board board;

    BoardView(Board board) {
        this.board = board;
    }

    void write() {
		MessageView.SEPARATOR.writeln();
		for (int i = 0; i < Coordinate.DIMENSION; i++) {
            MessageView.VERTICAL_LINE_LEFT.write();
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				if (this.board.getToken(new Coordinate(i, j)) == null) {
                    MessageView.EMPTY.write();
				} else {
                    Token token = this.board.getToken(new Coordinate(i, j));
                    new TokenView(token).write();
				}
                MessageView.VERTICAL_LINE_CENTERED.write();
			}
            MessageView.LINE_BREAK.writeln();
		}
		MessageView.SEPARATOR.writeln();
	}
}