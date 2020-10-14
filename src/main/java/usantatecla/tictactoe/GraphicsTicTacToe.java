package usantatecla.tictactoe;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.graphics.View;

public class GraphicsTicTacToe extends TicTacToe {
	
	@Override
	protected View createView(Game game) {
		return new View(game);
	}

	public static void main(String[] args) {
		new GraphicsTicTacToe().play();
	}
}