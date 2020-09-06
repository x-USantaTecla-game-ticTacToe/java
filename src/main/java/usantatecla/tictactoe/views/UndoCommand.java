package usantatecla.tictactoe.views;

import usantatecla.utils.Command;

public class UndoCommand extends Command {

	public UndoCommand() {
		super(MessageView.UNDO_COMMAND.getMessage());
	}

	@Override
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
