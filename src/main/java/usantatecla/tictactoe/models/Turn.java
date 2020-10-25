package usantatecla.tictactoe.models;

import java.util.Arrays;

import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.Token;

public class Turn {

	public static final int NUMBER_PLAYERS = 2;
	private Player[] players;
	private Board board;
	private int active;
	private int users;

	Turn(Board board) {
		assert board != null;

		this.board = board;
	}

	public Turn(Turn turn, Board board) {
		this.players = new Player[Turn.NUMBER_PLAYERS];
		for (int i = 0; i < Turn.NUMBER_PLAYERS; i++) {
			this.players[i] = turn.players[i].copy(board);
		}
		this.board = board;
		this.active = turn.active;
		this.users = turn.users;
	}

	public Turn copy(Board board) {
		return new Turn(this, board);
	}

	void setUsers(int users) {
		this.users = users;
		this.players = new Player[Turn.NUMBER_PLAYERS];
		for (int i = 0; i < Turn.NUMBER_PLAYERS; i++) {
			this.players[i] = new Player(Token.get(i), board);
		}
		this.active = 0;
	}

	void set(int active){
		this.active = active;
	}

	void next() {
		this.active = (this.active + 1) % Turn.NUMBER_PLAYERS;
	}

	boolean isUser() {
		return this.users == 2 || this.users == 1 && this.active == 0;
	}

	Error put(Coordinate coordinate) {
		return this.getPlayer().put(coordinate);
	}

	Player getPlayer() {
		return this.players[this.active];
	}

	Error move(Coordinate origin, Coordinate target) {
		return this.getPlayer().move(origin, target);
	}

	Token getToken() {
		return this.getPlayer().getToken();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turn other = (Turn) obj;
		if (active != other.active)
			return false;
		if (board == null) {
			if (other.board != null)
				return false;
		} else if (!board.equals(other.board))
			return false;
		if (!Arrays.equals(players, other.players))
			return false;
		if (users != other.users)
			return false;
		return true;
	}

	

}