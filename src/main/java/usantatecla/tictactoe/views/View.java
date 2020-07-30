package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResultController;
import usantatecla.tictactoe.controllers.StartController;

public abstract class View {

    protected StartController startController;

    protected PlayController playController;

    protected ResultController resultController;

	public View(StartController startController, PlayController playController,
	ResultController resultController) {
		this.startController = startController;
        this.playController = playController;
        this.resultController = resultController;
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