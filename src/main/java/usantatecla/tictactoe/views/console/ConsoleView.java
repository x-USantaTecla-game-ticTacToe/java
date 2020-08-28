package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.views.View;

public class ConsoleView extends View {

	private StartView startView;

	private PlayView playView;

	private ResumeView resumeView;

	public ConsoleView(StartController startController, PlayController playController,
			ResumeController resumeController) {
		super(startController, playController, resumeController);
		this.startView = new StartView(this.startController);
		this.playView = new PlayView(this.playController);
		this.resumeView = new ResumeView(this.resumeController);
	}

	@Override
	protected void start() {
		this.startView.interact();
	}

	@Override
	protected boolean play() {
		return this.playView.interact();
	}

	@Override
	protected boolean isNewGame() {
		return this.resumeView.interact();
	}
}