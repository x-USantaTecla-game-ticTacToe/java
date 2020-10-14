package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Game;

public class SubView {
  
  protected Game game;

	SubView(Game game) {
		assert game != null;
		
		this.game = game;
  }
  
}
