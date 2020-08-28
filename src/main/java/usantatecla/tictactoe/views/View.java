package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;

public abstract class View {
    protected Game game;

	public View(Game game) {
		this.game = game;
	}

	public void interact() {
		boolean newGame;
		do {
			this.start();
			boolean finished;
			do {
				finished = this.play();
			} while (!finished);
			newGame = this.isNewGame();
		} while (newGame);
	}

	protected abstract void start();

	protected abstract boolean play();

	protected abstract boolean isNewGame();
}