package usantatecla.tictactoe;

import usantatecla.tictactoe.views.View;
import usantatecla.tictactoe.views.graphics.GraphicsView;

public class GraphicsTicTacToe extends TicTacToe {

	@Override
	protected View createView() {
		return new GraphicsView();
	}

	public static void main(String[] args) {
		new GraphicsTicTacToe().play();
	}
}