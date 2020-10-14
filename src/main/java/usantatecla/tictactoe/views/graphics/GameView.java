package usantatecla.tictactoe.views.graphics;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Token;
import usantatecla.tictactoe.views.Message;
import usantatecla.tictactoe.views.console.TokenView;

@SuppressWarnings("serial")
public class GameView extends JPanel {

    private Game game;

    GameView(Game game) {
        this.game = game;
        this.setLayout(new GridBagLayout());
        this.add(new JLabel(Message.SEPARATOR.getMessage()), new Constraints(0, 0, 1, 1));
    }

    void write() {
        this.removeAll();
        this.setLayout(new GridBagLayout());
        this.add(new JLabel(Message.SEPARATOR.getMessage()), new Constraints(0, 0, 1, 1));
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            this.printRowBoard(i);
        }
        this.add(new JLabel(Message.SEPARATOR.getMessage()), new Constraints(0, 4, 1, 1));
    }

    private void printRowBoard(int row) {
        String boardRowToPresent = "";
        boardRowToPresent += Message.VERTICAL_LINE_LEFT.getMessage();
        for (int j = 0; j < Coordinate.DIMENSION; j++) {
            boardRowToPresent += this.getSquareBoardText(row, j);
        }
        JLabel label = new JLabel(boardRowToPresent);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(label, new Constraints(0, row + 1, 10, 1));
    }

    private String getSquareBoardText(int row, int column) {
        String squareBoardToPresent = "";
        Token token = this.game.getToken(new Coordinate(row, column));
        if (token == Token.NULL) {
            squareBoardToPresent += "-";
        } else {
            squareBoardToPresent += TokenView.SYMBOLS[token.ordinal()];
        }
        squareBoardToPresent += Message.VERTICAL_LINE_CENTERED.getMessage();
        return squareBoardToPresent;
    }

}
