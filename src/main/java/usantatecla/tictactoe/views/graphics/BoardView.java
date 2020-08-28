package usantatecla.tictactoe.views.graphics;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.views.MessageView;

@SuppressWarnings("serial")
class BoardView extends JPanel {

    BoardView(Logic logic) {
        this.setLayout(new GridBagLayout());
        this.add(new JLabel(MessageView.SEPARATOR.getMessage()), new Constraints(0, 0, 1, 1));
        for (int i = 0; i < logic.getCoordinateDimension(); i++) {
            this.printRowBoard(logic, i);
        }
        this.add(new JLabel(MessageView.SEPARATOR.getMessage()), new Constraints(0, 4, 1, 1));
    }

	private void printRowBoard(Logic logic, int row) {
        String boardRowToPresent = "";
        boardRowToPresent += MessageView.VERTICAL_LINE_LEFT.getMessage();
        for (int j = 0; j < logic.getCoordinateDimension(); j++) {
            boardRowToPresent += this.getSquareBoardText(logic, new Coordinate(row, j));
        }
        JLabel label = new JLabel(boardRowToPresent);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(label, new Constraints(0, row + 1, 10, 1));
}

	private String getSquareBoardText(Logic logic, Coordinate coordinate) {
        String squareBoardToPresent = "";
		if (logic.isEmptyToken(coordinate)) {
            squareBoardToPresent += MessageView.EMPTY.getMessage();
        } else {
            squareBoardToPresent += logic.getTokenChar(coordinate);
        }
        squareBoardToPresent += MessageView.VERTICAL_LINE_CENTERED.getMessage();
        return squareBoardToPresent;
	}
}