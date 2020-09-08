package usantatecla.tictactoe.views;

import usantatecla.tictactoe.events.RedoEvent;
import usantatecla.tictactoe.models.TicTacToe;
import usantatecla.utils.Observer;

public class RedoCommand extends Command {
	
	RedoCommand(TicTacToe tictactoe, Observer observer) {
		super(MessageView.REDO_COMMAND.getMessage(), tictactoe, observer);
	}

	@Override
	public void updateIsActive() {
		this.isActive = this.tictactoe.redoable();
	}

	@Override
	public void execute() {
		this.notify(new RedoEvent());		
	}

}
