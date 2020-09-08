package usantatecla.tictactoe.views;

import usantatecla.tictactoe.events.UndoEvent;
import usantatecla.tictactoe.models.TicTacToe;
import usantatecla.utils.Observer;

public class UndoCommand extends Command {

	UndoCommand(TicTacToe tictactoe, Observer observer) {
		super(MessageView.UNDO_COMMAND.getMessage(), tictactoe, observer);
	}

	@Override
	public void updateIsActive() {
		this.isActive = this.tictactoe.undoable();
	}

	@Override
	public void execute() {
		this.notify(new UndoEvent());
	}
	
}
