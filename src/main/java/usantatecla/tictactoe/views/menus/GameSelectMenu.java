package usantatecla.tictactoe.views.menus;

import usantatecla.tictactoe.controllers.StartController;
import usantatecla.utils.Menu;

class GameSelectMenu extends Menu {

	GameSelectMenu(StartController startController) {
		String[] gamesNames = startController.getGamesNames();
		for (String title : gamesNames) {
			this.addCommand(new GameSelectCommand(title, startController));
		}
	}

}
