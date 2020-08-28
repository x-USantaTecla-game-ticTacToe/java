package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.utils.WithConsoleView;
import usantatecla.tictactoe.types.Error;

class CoordinateView extends WithConsoleView {

    Logic logic;

    CoordinateView(Logic logic) {
        this.logic = logic;
    }

    Coordinate read(String title) {
        Coordinate coordinate;
        do {
			this.console.writeln(title);
            int row = this.console.readInt(MessageView.READ_ROW.getMessage()) - 1;
            int column = this.console.readInt(MessageView.READ_COLUMN.getMessage()) - 1;
            coordinate = new Coordinate(row, column);
            assert logic.isCoordinateValid(coordinate);
            if (!this.logic.isCoordinateValid(coordinate)) {
                new ErrorView(Error.WRONG_COORDINATES).writeln();
            }
        } while (!this.logic.isCoordinateValid(coordinate));
        return coordinate;
    }
}