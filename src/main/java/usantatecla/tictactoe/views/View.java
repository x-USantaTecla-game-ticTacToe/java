package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;

public abstract class View {

    protected StartController startController;

    protected PlayController playController;

    protected ResumeController resumeController;

	public View(StartController startController, PlayController playController,
	ResumeController resumeController) {
		this.startController = startController;
        this.playController = playController;
        this.resumeController = resumeController;
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