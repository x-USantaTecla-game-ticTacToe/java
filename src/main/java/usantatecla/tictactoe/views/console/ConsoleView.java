package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResultController;
import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.views.View;

public class ConsoleView extends View {

	private StartView startView;

	private PlayView playView;

	private ResultView resultView;

	public ConsoleView(StartController startController, PlayController playController,
			ResultController resultController) {
		super(startController, playController, resultController);
		this.startView = new StartView(this.startController);
		this.playView = new PlayView(this.playController);
		this.resultView = new ResultView(this.resultController);
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
	protected void result() {
		this.resultView.interact();
	}
}