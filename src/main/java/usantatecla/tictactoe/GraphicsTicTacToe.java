package usantatecla.tictactoe;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.graphics.GraphicsView;

public class GraphicsTicTacToe {
	private Game game;

	private GraphicsView graphicsView;

	private GraphicsTicTacToe() {
		this.game = new Game();
		this.graphicsView = new GraphicsView(this.game);
	}

	private void play() {
		this.graphicsView.interact();
	}

	public static void main(String[] args) {
		new GraphicsTicTacToe().play();
	}
}