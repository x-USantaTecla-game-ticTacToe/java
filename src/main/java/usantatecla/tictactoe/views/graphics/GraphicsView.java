package usantatecla.tictactoe.views.graphics;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.views.View;

public class GraphicsView extends View {

	private GameView gameView;

	public GraphicsView(StartController startController, PlayController playController,
	ResumeController resumeController) {
		super(startController, playController, resumeController);
		this.gameView = new GameView(startController, playController);
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
			this.resumeController.newGame();
			this.gameView = new GameView(this.startController, this.playController);
			return true;
		} else {
			this.gameView.setVisible(false);
			System.exit(0);
			return false;
		}
	}

}
