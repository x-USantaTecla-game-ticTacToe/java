package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.utils.YesNoDialog;

class ResumeView {
	
	private ResumeController resumeController;
	
	ResumeView (ResumeController resumeController){
		this.resumeController = resumeController;
	}

	boolean interact() {
		boolean newGame = new YesNoDialog().read(MessageView.RESUME.getMessage());
		if (newGame) {
			this.resumeController.newGame();
		}
		return newGame;
	}

}
