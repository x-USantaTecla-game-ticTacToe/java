package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.YesNoDialog;

class ResumeView extends SubView {

	public ResumeView(Game game) {
		super(game);
	}

	boolean interact() {
		boolean isResumed = new YesNoDialog().read(Message.RESUME.toString());
		if (isResumed){
			this.game.reset();
		}
		return isResumed;
	}

}
