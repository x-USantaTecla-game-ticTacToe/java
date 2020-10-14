package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;

public class SubView {

  protected Logic logic;

	SubView(Logic logic) {
		assert logic != null;
		
		this.logic = logic;
  }
  
}
