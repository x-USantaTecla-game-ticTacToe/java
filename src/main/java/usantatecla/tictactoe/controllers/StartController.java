package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.models.Turn;
import usantatecla.tictactoe.views.StartView;
import usantatecla.utils.PlayersDialog;

public class StartController extends Controller {
    
    public StartController(Session session) {
		super(session);
	}

	@Override
	public void control() {
		this.session.next();
		new StartView().write();
		int numberOfUsers = new PlayersDialog().read(Turn.NUM_PLAYERS);
		session.createPlayers(numberOfUsers);
	}
	
}