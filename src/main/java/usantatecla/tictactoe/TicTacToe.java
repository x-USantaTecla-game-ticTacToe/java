package usantatecla.tictactoe;

import usantatecla.utils.PlayersDialog;
import usantatecla.utils.WithConsoleModel;

class TicTacToe extends WithConsoleModel{

	private Board board;

	private Player[] players;

	private Turn turn;

	TicTacToe() {
		this.board = new Board();
		this.players = new Player[Turn.PLAYERS];
		this.turn = new Turn(this.players);
	}

	private void play() {
		Message.START_GAME.writeln();
		this.createPlayers();
		this.board.write();
		this.playUntilTicTacToe();
		int otherValue = this.turn.getOtherValue();
		this.turn.getOtherPlayer().writeWin(Token.values()[otherValue]);
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
		int users = new PlayersDialog().read(Turn.PLAYERS);
		for (int i = 0; i < users; i++) {
			this.players[i] = new UserPlayer(Token.values()[i], this.board);
		}
		for (int i = users; i < Turn.PLAYERS; i++) {
			this.players[i] = new MachinePlayer(Token.values()[i], this.board);
		}
	}

	public static void main(String[] args) {
		new TicTacToe().play();
	}

}
