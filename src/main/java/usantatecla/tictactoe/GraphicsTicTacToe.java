package usantatecla.tictactoe;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.graphics.View;

public class GraphicsTicTacToe extends TicTacToe {
	
	@Override
	protected View createView(Logic logic){
		return new View(logic);
	}

	public static void main(String[] args) {
		new GraphicsTicTacToe().play();
	}

}