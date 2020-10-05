package usantatecla.tictactoe;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.graphics.View;

public class GraphicsTicTacToe {

	private Game game;
	private View view;

	private GraphicsTicTacToe() {
		this.game = new Game();
		this.view = new View(this.game);
	}

	private void play() {
		this.view.interact();
	}

	public static void main(String[] args) {
		new GraphicsTicTacToe().play();
	}

}