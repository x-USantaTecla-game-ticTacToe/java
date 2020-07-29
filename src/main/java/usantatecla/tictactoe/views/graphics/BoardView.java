package usantatecla.tictactoe.views.graphics;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import usantatecla.tictactoe.models.Board;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Token;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.tictactoe.views.TokenView;

@SuppressWarnings("serial")
class BoardView extends JPanel {

    BoardView(Board board) {
        this.setLayout(new GridBagLayout());
        String boardToPresent = "";
        this.add(new JLabel(MessageView.SEPARATOR.getMessage()), new Constraints(0, 0, 1, 1));
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            boardToPresent += MessageView.VERTICAL_LINE_LEFT.getMessage();
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                if (board.getToken(new Coordinate(i, j)) == null) {
                    boardToPresent += MessageView.EMPTY.getMessage();
                } else {
                    Token token = board.getToken(new Coordinate(i, j));
                    boardToPresent += new TokenView(token).getToken();
                }
                boardToPresent += MessageView.VERTICAL_LINE_CENTERED.getMessage();
            }
            JLabel label = new JLabel(boardToPresent);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            this.add(label, new Constraints(0, i + 1, 10, 1));
            boardToPresent = "";
        }
        this.add(new JLabel(MessageView.SEPARATOR.getMessage()), new Constraints(0, 4, 1, 1));
    }
}