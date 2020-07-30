package usantatecla.tictactoe.views.graphics;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResultController;
import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.views.View;

public class GraphicsView extends View {

	private GameView gameView;

	public GraphicsView(StartController startController, PlayController playController,
	ResultController resultController) {
		super(startController, playController, resultController);
		this.gameView = new GameView(startController, playController, resultController);
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
	protected void result() {
		this.gameView.result();
	}

}
