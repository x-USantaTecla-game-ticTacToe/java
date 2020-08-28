package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.utils.YesNoDialog;

class ResumeView {
	
	private Logic logic;
	
	ResumeView (Logic logic){
		this.logic = logic;
	}

	boolean interact() {
		boolean newGame = new YesNoDialog().read(MessageView.RESUME.getMessage());
		if (newGame) {
			this.logic.newGame();
		}
		return newGame;
	}

}
