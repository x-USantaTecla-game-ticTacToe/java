package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.YesNoDialog;

class ResumeView {

	private ResumeController resumeController;

	public ResumeView(ResumeController resumeController){
		this.resumeController = resumeController;
	}

	boolean interact() {
		boolean isResumed = new YesNoDialog().read(Message.RESUME.toString());
		if (isResumed){
			this.resumeController.resume();
		}
		return isResumed;
	}

}
