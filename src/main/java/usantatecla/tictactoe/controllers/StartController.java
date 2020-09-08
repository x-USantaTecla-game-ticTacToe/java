package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Turn;
import usantatecla.tictactoe.views.StartView;
import usantatecla.utils.PlayersDialog;

class StartController {

	int read() {
		new StartView().write();
		int numberOfUsers = new PlayersDialog().read(Turn.NUM_PLAYERS);
		return numberOfUsers;
	}
	
}