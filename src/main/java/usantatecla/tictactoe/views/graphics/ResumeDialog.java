package usantatecla.tictactoe.views.graphics;

import javax.swing.JOptionPane;

import usantatecla.tictactoe.views.MessageView;

class ResumeDialog {

	private boolean newGame;

	ResumeDialog() {
		this.newGame = (JOptionPane.showConfirmDialog(null, MessageView.RESUME.getMessage(),
				MessageView.START_GAME.getMessage(), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
	}

	boolean isNewGame() {
		return this.newGame;
	}

}
