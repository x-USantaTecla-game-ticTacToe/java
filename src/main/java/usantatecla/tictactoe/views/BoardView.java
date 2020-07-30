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
			this.printRowBoard(i);
		}
		MessageView.SEPARATOR.writeln();
	}

	private void printRowBoard(int row) {
		MessageView.VERTICAL_LINE_LEFT.write();
		for (int j = 0; j < Coordinate.DIMENSION; j++) {
			this.printColumnBoard(row, j);
		}
		MessageView.LINE_BREAK.writeln();
	}

	private void printSquareBoard(int row, int column) {
		Token tokenToWrite = this.board.getToken(new Coordinate(row, column));
		if (tokenToWrite == null) {
			MessageView.EMPTY.write();
		} else {
			new TokenView(tokenToWrite).write();
		}
		MessageView.VERTICAL_LINE_CENTERED.write();
	}
}