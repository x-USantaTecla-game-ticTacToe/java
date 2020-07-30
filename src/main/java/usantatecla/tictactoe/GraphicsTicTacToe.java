package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.View;
import usantatecla.tictactoe.views.graphics.GraphicsView;

public class GraphicsTicTacToe extends TicTacToe {

	@Override
	protected View createView(Logic logic) {
		return new GraphicsView(logic);
	}

	public static void main(String[] args) {
		new GraphicsTicTacToe().play();
	}
}