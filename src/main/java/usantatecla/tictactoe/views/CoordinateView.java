package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.utils.WithConsoleModel;

class CoordinateView extends WithConsoleModel {

    Coordinate read(String title) {
        Coordinate coordinate;
        do {
			this.console.writeln(title);
            int row = this.console.readInt("Row: ") - 1;
            int column = this.console.readInt("Column: ") - 1;
            coordinate = new Coordinate(row, column);
        } while (!coordinate.isValid());
        return coordinate;
    }
}