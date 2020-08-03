package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Board;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Token;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.utils.WithConsoleView;

class BoardView extends WithConsoleView {
    
    Board board;

    BoardView(Board board) {
        this.board = board;
    }

    void write() {
        this.console.writeln(MessageView.SEPARATOR.getMessage());
		for (int i = 0; i < Coordinate.DIMENSION; i++) {
			this.printRowBoard(i);
        }
        this.console.writeln(MessageView.SEPARATOR.getMessage());
	}

	private void printRowBoard(int row) {
        this.console.write(MessageView.VERTICAL_LINE_LEFT.getMessage());
		for (int j = 0; j < Coordinate.DIMENSION; j++) {
			this.printSquareBoard(row, j);
		}
		this.console.writeln();
	}

	private void printSquareBoard(int row, int column) {
		Token tokenToWrite = this.board.getToken(new Coordinate(row, column));
		if (tokenToWrite == null) {
            this.console.write(MessageView.EMPTY.getMessage());
		} else {
			this.console.write(tokenToWrite.getChar());
        }
        this.console.write(MessageView.VERTICAL_LINE_CENTERED.getMessage());
	}
}