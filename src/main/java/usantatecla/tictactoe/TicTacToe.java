package usantatecla.tictactoe;

import usantatecla.utils.PlayersDialog;
import usantatecla.utils.WithConsoleModel;
import usantatecla.utils.YesNoDialog;

class TicTacToe extends WithConsoleModel{

	private Board board;

	private Player[] players;

	private Turn turn;

	TicTacToe() {
		this.newGame();
	}

	private void play() {
		boolean newGame;
		do {
			Message.START_GAME.writeln();
			this.createPlayers();
			this.board.write();
			this.playUntilTicTacToe();
			int otherValue = this.turn.getOtherValue();
			this.turn.getOtherPlayer().writeWin(Token.values()[otherValue]);
			Message.RESUME.write();
			newGame = new YesNoDialog().read();
			if (newGame) {
				this.newGame();
			}
		} while (newGame);
	}

	private void playUntilTicTacToe() {
		do {
			if (!this.board.isCompleted()) {
				this.turn.getPlayer().put();
			} else {
				this.turn.getPlayer().move();
			}
			this.turn.change();
			this.board.write();
		} while (!this.board.isTicTacToe(this.turn.getOtherPlayer().getToken()));
	}

	private void createPlayers() {
		int users = new PlayersDialog().read(Turn.NUM_PLAYERS);
		for (int i = 0; i < users; i++) {
			this.players[i] = new UserPlayer(Token.values()[i], this.board);
		}
		for (int i = users; i < Turn.NUM_PLAYERS; i++) {
			this.players[i] = new MachinePlayer(Token.values()[i], this.board);
		}
	}

	private void newGame() {
		this.board = new Board();
		this.players = new Player[Turn.NUM_PLAYERS];
		this.turn = new Turn(this.players);
	}

	public static void main(String[] args) {
		new TicTacToe().play();
	}

}
