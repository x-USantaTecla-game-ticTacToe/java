package usantatecla.tictactoe.views.graphics;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.tictactoe.views.TokenView;

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
            boardRowToPresent += this.getSquareBoardText(logic, row, j);
        }
        JLabel label = new JLabel(boardRowToPresent);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(label, new Constraints(0, row + 1, 10, 1));
}

	private String getSquareBoardText(Logic logic, int row, int column) {
        String squareBoardToPresent = "";
		if (logic.getToken(row, column) == null) {
            squareBoardToPresent += MessageView.EMPTY.getMessage();
        } else {
            squareBoardToPresent += new TokenView(logic.getToken(row, column)).getToken();
        }
        squareBoardToPresent += MessageView.VERTICAL_LINE_CENTERED.getMessage();
        return squareBoardToPresent;
	}
}