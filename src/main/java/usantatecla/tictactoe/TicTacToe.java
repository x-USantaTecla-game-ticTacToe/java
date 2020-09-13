package usantatecla.tictactoe;

import usantatecla.utils.YesNoDialog;

class TicTacToe{

	private Board board;
	private Turn turn;

	private void play() {
		do {
			this.board = new Board(Turn.NUMBER_PLAYERS);
			this.turn = new Turn(this.board);
			this.board.write();
			do {
				this.turn.play();
				this.board.write();
			} while (!this.board.isTicTacToe(this.turn.getToken()));
			this.turn.writeWinner();
		} while (this.isResumedGame());
	}

	private boolean isResumedGame(){
		return new YesNoDialog().read(Message.RESUME.toString());
	}

	public static void main(String[] args) {
		new TicTacToe().play();
	}

}
