package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.views.Message;
import usantatecla.utils.YesNoDialog;

class ResumeView {

	boolean interact(ResumeController resumeController) {
		boolean isResumed = new YesNoDialog().read(Message.RESUME.toString());
		if (isResumed){
			resumeController.resume();
		} else {
			resumeController.next();
		}
		return isResumed;
	}

}
