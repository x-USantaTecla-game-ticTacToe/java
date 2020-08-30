package usantatecla.tictactoe.views.menus;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.views.models.GameView;
import usantatecla.tictactoe.views.models.MessageView;

class UndoCommand extends Command {

	private PlayController playController;

	UndoCommand(PlayController playController) {
		super(MessageView.UNDO_COMMAND.getMessage(), playController);
		this.playController = (PlayController) this.acceptorController;
	}

	
	protected void execute() {
		(this.playController).undo();
		new GameView((this.playController));
	}

	
	protected boolean isActive() {
		return (this.playController).undoable();
	}
	
}
