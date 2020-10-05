package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.views.Message;
import usantatecla.utils.YesNoDialog;

class ResumeView {

	boolean interact() {
		return new YesNoDialog().read(Message.RESUME.toString());
	}

}
