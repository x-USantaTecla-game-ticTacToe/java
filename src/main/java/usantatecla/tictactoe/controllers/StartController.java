package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.State;

public class StartController extends Controller {
    
    public StartController(Game game, State state) {
		super(game, state);
	}

	public void start() {
		this.state.next();
	}

	public void createPlayers(int numberOfUsers) {
		this.game.createPlayers(numberOfUsers);
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}
}