package usantatecla.tictactoe.views.graphics;

import usantatecla.tictactoe.models.Game;

public class View extends usantatecla.tictactoe.views.View {

	private PlayView playView;

	public View(Game game) {
		super(game);
		this.playView = new PlayView(this.game);
	}

	@Override
	protected void start() {
		this.playView.start();
	}

	@Override
	protected void play() {
		this.playView.play();
	}

	@Override
	protected boolean isNewGame() {
		ResumeDialog resumeDialog = new ResumeDialog();
		boolean newGame = resumeDialog.isNewGame();
		if (newGame) {
			this.game.newGame();
			this.playView = new PlayView(this.game);
			return true;
		} else {
			this.playView.setVisible(false);
			System.exit(0);
			return false;
		}
	}

}
