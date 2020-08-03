package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.PlayController;

abstract class Command extends usantatecla.utils.Command {

	protected PlayController playController;

	protected Command(String title, PlayController playController) {
		super(title);
		this.playController = playController;
	}
	
}
