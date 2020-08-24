package usantatecla.tictactoe.views.menus;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.views.models.MessageView;

class ExitCommand extends Command {

	protected ExitCommand(PlayController playController) {
		super(MessageView.EXIT_COMMAND.getMessage(), playController);
	}

	@Override
	protected void execute() {
		((PlayController) this.acceptorController).next();	
	}

	@Override
	protected boolean isActive() {
		return true;
	}

}
