package usantatecla.tictactoe.views.menus;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.views.models.GameView;
import usantatecla.tictactoe.views.models.MessageView;

class RedoCommand extends Command{
	
	RedoCommand(PlayController playController) {
		super(MessageView.REDO_COMMAND.getMessage(), playController);
	}

	@Override
	protected void execute() {
		((PlayController) this.acceptorController).redo();
		new GameView(((PlayController) this.acceptorController));
		
	}

	@Override
	protected boolean isActive() {
		return ((PlayController) this.acceptorController).redoable();
	}

}
