package usantatecla.tictactoe.models;

public class Turn {

	public static final int PLAYERS = 2;

	private int value;

	private Player[] players;

	public Turn(Player[] players) {
		this.value = 0;
		this.players = players;
	}

	public Turn(Player[] players, int value) {
		this.value = value;
		this.players = players;
	}

	void change() {
		this.value = this.getOtherValue();
	}

	Player getPlayer() {
		return this.players[this.value];
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	int getOtherValue() {
		return (this.value + 1) % Turn.PLAYERS;
	}

	Player getOtherPlayer() {
		return this.players[this.getOtherValue()];
	}

	Turn copy(Player[] players) {
		return new Turn(players, this.value);
	}

}
