package usantatecla.tictactoe.views;

import usantatecla.utils.Command;

public class MovementCommand extends Command {

    public MovementCommand() {
		super(MessageView.PROPOSE_COMMAND.getMessage());
	}

    @Override
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
    
}