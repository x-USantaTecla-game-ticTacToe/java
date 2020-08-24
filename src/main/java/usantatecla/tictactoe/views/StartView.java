package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.views.menus.StartMenu;
import usantatecla.tictactoe.views.models.MessageView;
import usantatecla.utils.WithConsoleView;

class StartView extends WithConsoleView {

    void interact(StartController startController) {
		this.console.writeln(MessageView.START_GAME.getMessage());
		new StartMenu(startController).execute();
	}
}