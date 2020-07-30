package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.View;

public class ConsoleView extends View {

	private StartView startView;

	private PlayView playView;

	private ResultView resultView;

	public ConsoleView(Logic logic) {
		super(logic);
		this.startView = new StartView(this.logic);
		this.playView = new PlayView(this.logic);
		this.resultView = new ResultView(this.logic);
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