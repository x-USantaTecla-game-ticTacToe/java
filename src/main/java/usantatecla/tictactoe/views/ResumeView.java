package usantatecla.tictactoe.views;

import usantatecla.utils.YesNoDialog;

public class ResumeView {

	public boolean read() {
		return new YesNoDialog().read(MessageView.RESUME.getMessage());
	}

}
