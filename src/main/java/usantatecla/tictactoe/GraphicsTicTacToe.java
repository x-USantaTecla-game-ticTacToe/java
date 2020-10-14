package usantatecla.tictactoe;

import usantatecla.tictactoe.views.graphics.View;

public class GraphicsTicTacToe extends TicTacToe {
	
	@Override
	protected View createView(){
		return new View();
	}

	public static void main(String[] args) {
		new GraphicsTicTacToe().play();
	}

}