package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;

public abstract class View {
    protected Game game;

	public View(Game game) {
		this.game = game;
	}

	public void interact() {
		this.start();
		boolean finished;
		do {
			finished = this.play();
		} while (!finished);
		this.result();
	}

	protected abstract void start();

	protected abstract boolean play();

	protected abstract void result();
}