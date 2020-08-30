package usantatecla.tictactoe.models;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class Turn {

	public static final int NUM_PLAYERS = 2;

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

	int getValue() {
		return this.value;
	}

	private int getOtherValue() {
		return (this.value + 1) % Turn.NUM_PLAYERS;
	}

	Player getOtherPlayer() {
		return this.players[this.getOtherValue()];
	}

	Turn copy(Player[] players) {
		return new Turn(players, this.value);
	}

	void save(FileWriter fileWriter) {
		try {
			fileWriter.write(this.value + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void load(BufferedReader bufferedReader) {
		try {
			this.value = Integer.parseInt(bufferedReader.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
