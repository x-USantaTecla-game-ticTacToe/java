package usantatecla.tictactoe.views.graphics;

import javax.swing.JOptionPane;

import usantatecla.tictactoe.views.Message;

class ResumeView {

	private boolean newGame;

	ResumeView() {
		this.newGame = (JOptionPane.showConfirmDialog(null, Message.RESUME.getMessage(),
				Message.TITTLE.getMessage(), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
	}

	boolean isResumedGame() {
		return this.newGame;
	}

}
