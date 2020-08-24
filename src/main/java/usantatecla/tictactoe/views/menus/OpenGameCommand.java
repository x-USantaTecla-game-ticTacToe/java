package usantatecla.tictactoe.views.menus;

import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.views.models.MessageView;

class OpenGameCommand extends Command{

	protected OpenGameCommand(StartController startController) {
		super(MessageView.OPENGAME_COMMAND.getMessage(), startController);
	}

	@Override
	protected void execute() {
		new GameSelectMenu((StartController) this.acceptorController).execute();
	}

	@Override
	protected boolean isActive() {
		return true;
	}

}
