package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.Logic;

public abstract class View {

    protected Logic logic;

	public View(Logic logic) {
		this.logic = logic;
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