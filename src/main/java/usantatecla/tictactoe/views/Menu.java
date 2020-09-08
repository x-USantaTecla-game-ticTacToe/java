package usantatecla.tictactoe.views;

import java.util.ArrayList;

import usantatecla.tictactoe.models.TicTacToe;
import usantatecla.utils.Command;
import usantatecla.utils.Observer;

class Menu extends usantatecla.utils.Menu {

	Menu(TicTacToe tictactoe, Observer observer) {
		this.commands = new ArrayList<Command>();
		this.commands.add(new MovementCommand(tictactoe, observer));
		this.commands.add(new UndoCommand(tictactoe, observer));
		this.commands.add(new RedoCommand(tictactoe, observer));
	}

}
