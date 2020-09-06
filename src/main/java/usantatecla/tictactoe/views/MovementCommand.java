package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Session;

public class MovementCommand extends Command {

    public MovementCommand(Session session) {
		super(MessageView.PROPOSE_COMMAND.getMessage(), session);
	}

    @Override
	public void updateIsActive() {
		this.isActive = true;
	}
    
}