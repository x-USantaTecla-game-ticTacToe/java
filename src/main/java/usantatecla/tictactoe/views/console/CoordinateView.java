package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.utils.WithConsoleView;
import usantatecla.tictactoe.types.Error;

class CoordinateView extends WithConsoleView {

    Logic logic;

    CoordinateView(Logic logic) {
        this.logic = logic;
    }

    int[] read(String title) {
        int[] coordinate = new int[2];
        int row = 0;
        int column = 0;
        do {
			this.console.writeln(title);
            row = this.console.readInt(MessageView.READ_ROW.getMessage()) - 1;
            column = this.console.readInt(MessageView.READ_COLUMN.getMessage()) - 1;
            if (!this.logic.isCoordinateValid(row, column)) {
                new ErrorView(Error.WRONG_COORDINATES).writeln();
            }
        } while (!this.logic.isCoordinateValid(row, column));
        coordinate[0] = row;
        coordinate[1] = column;
        return coordinate;
    }
}