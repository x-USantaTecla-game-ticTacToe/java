package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.View;

public class ConsoleView extends View {
    
    private StartView startView;

	private PlayView playView;

	private ResultView resultView;

	public ConsoleView(Game game) {
		super(game);
		this.startView = new StartView(this.game);
		this.playView = new PlayView(this.game);
		this.resultView = new ResultView(this.game);
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