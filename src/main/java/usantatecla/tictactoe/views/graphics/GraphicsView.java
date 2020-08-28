package usantatecla.tictactoe.views.graphics;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.View;

public class GraphicsView extends View {

	private GameView gameView;

	public GraphicsView(Game game) {
		super(game);
		this.gameView = new GameView(this.game);
	}

	@Override
	protected void start() {
		this.gameView.start();
	}

	@Override
	protected boolean play() {
		return this.gameView.play();
	}

	@Override
	protected boolean isNewGame() {
		ResumeDialog resumeDialog = new ResumeDialog();
		boolean newGame = resumeDialog.isNewGame();
		if (newGame) {
			this.game.newGame();
			this.gameView = new GameView(this.game);
			return true;
		} else {
			this.gameView.setVisible(false);
			System.exit(0);
			return false;
		}
	}

}
