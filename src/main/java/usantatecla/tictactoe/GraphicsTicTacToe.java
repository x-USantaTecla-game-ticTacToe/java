package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResultController;
import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.views.View;
import usantatecla.tictactoe.views.graphics.GraphicsView;

public class GraphicsTicTacToe extends TicTacToe {

	@Override
	protected View createView(StartController startController, PlayController playController,
			ResultController resultController) {
		return new GraphicsView(startController, playController, resultController);
	}

	public static void main(String[] args) {
		new GraphicsTicTacToe().play();
	}
}