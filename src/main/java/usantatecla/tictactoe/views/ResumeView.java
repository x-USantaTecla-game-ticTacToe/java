package usantatecla.tictactoe.views;

import usantatecla.utils.YesNoDialog;

class ResumeView {

	boolean interact() {
		return new YesNoDialog().read(Message.RESUME.toString());
	}

}
