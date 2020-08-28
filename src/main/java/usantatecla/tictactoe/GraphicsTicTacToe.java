package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.views.View;
import usantatecla.tictactoe.views.graphics.GraphicsView;

public class GraphicsTicTacToe extends TicTacToe {

	@Override
	protected View createView(StartController startController, PlayController playController,
			ResumeController resumeController) {
		return new GraphicsView(startController, playController, resumeController);
	}

	public static void main(String[] args) {
		new GraphicsTicTacToe().play();
	}
}