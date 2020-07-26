package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;

public class View {
    protected Game game;

	private StartView startView;

	private PlayView playView;

	private ResultView resultView;

	public View(Game game) {
		this.game = game;
		this.startView = new StartView(this.game);
		this.playView = new PlayView(this.game);
		this.resultView = new ResultView(this.game);
	}

	public void interact() {
		this.startView.interact();
		boolean finished;
		do {
			finished = this.playView.interact();
		} while (!finished);
		this.resultView.interact();
	}
}