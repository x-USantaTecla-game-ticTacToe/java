package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.utils.YesNoDialog;

class ResumeView {
	
	private Game game;
	
	ResumeView (Game game){
		this.game = game;
	}

	boolean interact() {
		boolean newGame = new YesNoDialog().read(MessageView.RESUME.getMessage());
		if (newGame) {
			this.game.newGame();
		}
		return newGame;
	}

}
