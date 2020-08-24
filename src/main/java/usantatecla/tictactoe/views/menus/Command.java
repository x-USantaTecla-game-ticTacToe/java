package usantatecla.tictactoe.views.menus;

import usantatecla.tictactoe.controllers.AcceptorController;

abstract class Command extends usantatecla.utils.Command {

	protected AcceptorController acceptorController;

	protected Command(String title, AcceptorController acceptorController) {
		super(title);
		this.acceptorController = acceptorController;
	}
	
}
