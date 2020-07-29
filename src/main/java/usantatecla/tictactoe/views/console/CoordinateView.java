package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.utils.WithConsoleModel;

class CoordinateView extends WithConsoleModel {

    Coordinate read(String title) {
        Coordinate coordinate;
        do {
			this.console.writeln(title);
            int row = this.console.readInt(MessageView.READ_ROW.getMessage()) - 1;
            int column = this.console.readInt(MessageView.READ_COLUMN.getMessage()) - 1;
            coordinate = new Coordinate(row, column);
        } while (!coordinate.isValid());
        return coordinate;
    }
}