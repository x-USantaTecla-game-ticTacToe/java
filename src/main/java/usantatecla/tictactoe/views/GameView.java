package usantatecla.tictactoe.views;

public class GameView {

    public void writeSeparator() {
        MessageView.SEPARATOR.writeln();
    }

    public void writeVerticalLineLeft() {
        MessageView.VERTICAL_LINE_LEFT.write();
    }

    public void writeVerticalLineCentered() {
        MessageView.VERTICAL_LINE_CENTERED.write();
    }

    public void writeEmpty() {
        MessageView.EMPTY.write();
    }

    public void writeLineBreak() {
        new BoardView().writeln();
    }

    public void writeToken(char token) {
        new BoardView().write(token);
    }

    public void writeWinner(char winner) {
        new ResultView().write(winner);
    }
    
}