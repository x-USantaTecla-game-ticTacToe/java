package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.types.Token;
import usantatecla.tictactoe.views.GameView;

public abstract class InGameController extends Controller {

	private GameView gameView;

	InGameController(Session session) {
		super(session);
		this.gameView = new GameView();
	}

	@Override
	public void control() {
		this.inGameControl();
		this.writeBoard();
		if (this.session.isTicTacToe()) {
			this.gameView.writeWinner(Token.values()[session.getValueFromTurn()].getChar());
			this.session.next();
		}
	}

	private void writeBoard() {
		this.gameView.writeSeparator();
		for (int i = 0; i < this.session.getCoordinateDimension(); i++) {
			this.printRowBoard(i);
        }
        this.gameView.writeSeparator();
	}

	private void printRowBoard(int row) {
        this.gameView.writeVerticalLineLeft();
		for (int j = 0; j < this.session.getCoordinateDimension(); j++) {
			this.printSquareBoard(new Coordinate(row, j));
		}
		this.gameView.writeLineBreak();
	}

	private void printSquareBoard(Coordinate coordinate) {
		if (this.session.isEmptyToken(coordinate)) {
           	this.gameView.writeEmpty();
		} else {
			this.gameView.writeToken(this.session.getTokenChar(coordinate));
        }
        this.gameView.writeVerticalLineCentered();
	}

	protected abstract void inGameControl();

}
