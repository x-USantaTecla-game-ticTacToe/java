package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.utils.Menu;

public class PlayMenu extends Menu {

    PlayMenu(PlayController playController) {
		this.addCommand(new MovementCommand(playController));
		this.addCommand(new UndoCommand(playController));
		this.addCommand(new RedoCommand(playController));
	}
    
}