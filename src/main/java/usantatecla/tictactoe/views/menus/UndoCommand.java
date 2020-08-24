package usantatecla.tictactoe.views.menus;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.views.models.GameView;
import usantatecla.tictactoe.views.models.MessageView;

class UndoCommand extends Command {

	UndoCommand(PlayController playController) {
		super(MessageView.UNDO_COMMAND.getMessage(), playController);
	}

	
	protected void execute() {
		((PlayController) this.acceptorController).undo();
		new GameView(((PlayController) this.acceptorController));
	}

	
	protected boolean isActive() {
		return ((PlayController) this.acceptorController).undoable();
	}
	
}
