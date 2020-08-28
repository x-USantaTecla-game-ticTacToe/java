package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.Logic;

public abstract class View {

    protected Logic logic;

	public View(Logic logic) {
		this.logic = logic;
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