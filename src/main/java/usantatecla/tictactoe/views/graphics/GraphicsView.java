package usantatecla.tictactoe.views.graphics;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.View;

public class GraphicsView extends View {

	private GameView gameView;

	public GraphicsView(Logic logic) {
		super(logic);
		this.gameView = new GameView(logic);
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
