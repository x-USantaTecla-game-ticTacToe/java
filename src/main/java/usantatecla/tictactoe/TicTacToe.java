package usantatecla.tictactoe;

import usantatecla.utils.YesNoDialog;

class TicTacToe {

	private Board board;
	private Turn turn;

	TicTacToe(){
		this.board = new Board();
	}

	private void play() {
		do {
			this.playGame();
		} while (this.isResumedGame());
	}

	private void playGame() {
		this.turn = new Turn(this.board);
		this.board.write();
		do {
			this.turn.play();
			this.board.write();
		} while (!this.board.isTicTacToe(this.turn.getToken()));
		this.turn.writeWinner();
	}

	private boolean isResumedGame() {
		boolean isResumed = new YesNoDialog().read(Message.RESUME.toString());
		if (isResumed) {
			this.board.reset();
		}
		return isResumed;
	}

	public static void main(String[] args) {
		new TicTacToe().play();
	}

}
