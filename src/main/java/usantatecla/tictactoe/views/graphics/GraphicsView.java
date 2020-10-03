package usantatecla.tictactoe.views.graphics;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.View;

public class GraphicsView extends View {

	private PlayView playView;

	public GraphicsView(Game game) {
		super(game);
		this.playView = new PlayView(this.game);
	}

	@Override
	protected void start() {
		this.playView.start();
	}

	@Override
	protected boolean play() {
		return this.playView.play();
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
