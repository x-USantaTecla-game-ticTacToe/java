package usantatecla.tictactoe.views.models;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.utils.WithConsoleView;
import usantatecla.tictactoe.types.Error;

class CoordinateView extends WithConsoleView {

    PlayController playController;

    CoordinateView(PlayController playController) {
        this.playController = playController;
    }

    int[] read(String title) {
        int[] coordinate = new int[2];
        int row = 0;
        int column = 0;
        do {
			this.console.writeln(title);
            row = this.console.readInt(MessageView.READ_ROW.getMessage()) - 1;
            column = this.console.readInt(MessageView.READ_COLUMN.getMessage()) - 1;
            assert this.playController.isCoordinateValid(row, column);
            if (!this.playController.isCoordinateValid(row, column)) {
                new ErrorView(Error.WRONG_COORDINATES).writeln();
            }
        } while (!this.playController.isCoordinateValid(row, column));
        coordinate[0] = row;
        coordinate[1] = column;
        return coordinate;
    }
}