package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.utils.WithConsoleView;

class CoordinateView extends WithConsoleView {

    Coordinate read(String title) {
        this.console.writeln(title);
        int row = this.console.readInt(MessageView.READ_ROW.getMessage()) - 1;
        int column = this.console.readInt(MessageView.READ_COLUMN.getMessage()) - 1;
        return new Coordinate(row, column);
    }
}