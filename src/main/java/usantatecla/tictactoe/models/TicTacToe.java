package usantatecla.tictactoe.models;

import usantatecla.tictactoe.events.OPlayerWinnerEvent;
import usantatecla.tictactoe.events.XPlayerWinnerEvent;
import usantatecla.utils.Observed;

public class TicTacToe extends Observed {

    private Game game;
	
	private Registry registry;
	
	public TicTacToe(Game game) {
		this.game = game;
		this.registry = new Registry(this.game);
	}
	
	public void createPlayers(int numberOfPlayers) {
		this.game.createPlayers(numberOfPlayers);
	}

	public boolean undoable() {
		return this.registry.undoable();
	}

	public boolean redoable() {
		return this.registry.redoable();
	}

	public boolean isTicTacToe() {
		boolean isTicTacToe = this.game.isTicTacToe();
		if (isTicTacToe) {
            if (this.game.getValueFromTurn() == 0) {
                this.notify(new OPlayerWinnerEvent());
            } else {
                this.notify(new XPlayerWinnerEvent());
            }
		}
		return isTicTacToe;
	}
	
	public void undo() {
		this.registry.undo(this.game);
	}

	public void redo() {
		this.registry.redo(this.game);
	}

	public void registry() {
		this.registry.registry();
	}

	public void newGame() {
		this.game.newGame();
		this.registry.reset();
	}
}
