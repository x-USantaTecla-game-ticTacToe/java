package usantatecla.tictactoe.views;

import usantatecla.tictactoe.events.MoveEvent;
import usantatecla.tictactoe.models.TicTacToe;
import usantatecla.utils.Observer;

public class MovementCommand extends Command {

    public MovementCommand(TicTacToe tictactoe, Observer observer) {
		super(MessageView.PROPOSE_COMMAND.getMessage(), tictactoe, observer);
	}

    @Override
	public void updateIsActive() {
		this.isActive = true;
	}

	@Override
	public void execute() {
		this.notify(new MoveEvent());
	}
    
}