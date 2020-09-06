package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Session;

public class RedoCommand extends Command {
	
	public RedoCommand(Session session) {
		super(MessageView.REDO_COMMAND.getMessage(), session);
	}

	@Override
	public void updateIsActive() {
		this.isActive = this.session.redoable();
	}

}
