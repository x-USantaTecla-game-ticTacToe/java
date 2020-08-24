package usantatecla.tictactoe.views.models;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.utils.WithConsoleView;

public class BoardView extends WithConsoleView {
    
    private PlayController playController;

    public BoardView(PlayController playController) {
        this.playController = playController;
    }

    public void write() {
        this.console.writeln(MessageView.SEPARATOR.getMessage());
		for (int i = 0; i < this.playController.getCoordinateDimension(); i++) {
			this.printRowBoard(i);
        }
        this.console.writeln(MessageView.SEPARATOR.getMessage());
	}

	private void printRowBoard(int row) {
        this.console.write(MessageView.VERTICAL_LINE_LEFT.getMessage());
		for (int j = 0; j < this.playController.getCoordinateDimension(); j++) {
			this.printSquareBoard(row, j);
		}
		this.console.writeln();
	}

	private void printSquareBoard(int row, int column) {
		if (this.playController.isEmptyToken(row, column)) {
            this.console.write(MessageView.EMPTY.getMessage());
		} else {
			this.console.write(this.playController.getTokenChar(row, column));
        }
        this.console.write(MessageView.VERTICAL_LINE_CENTERED.getMessage());
	}
}