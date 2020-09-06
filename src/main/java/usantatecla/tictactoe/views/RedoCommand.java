package usantatecla.tictactoe.views;

import usantatecla.utils.Command;

public class RedoCommand extends Command{
	
	public RedoCommand() {
		super(MessageView.REDO_COMMAND.getMessage());
	}

	@Override
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
