package usantatecla.tictactoe.views.graphics;

import usantatecla.tictactoe.models.Game;

public class View extends usantatecla.tictactoe.views.View {

	public View(Game game) {
		super(game);
	}

	@Override
	protected void start() {
	}

	@Override
	protected void play() {
	}

	@Override
	protected boolean isNewGame() {
		return new ResumeDialog().isNewGame();
	}

}
