package usantatecla.tictactoe;

import java.util.HashMap;
import java.util.Map;

import usantatecla.tictactoe.controllers.Controller;
import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.types.StateValue;

public class TicTacToe {

    private Session session;

	private Map<StateValue, Controller> controllers;

    TicTacToe() {
        this.session = new Session();
		this.controllers = new HashMap<StateValue, Controller>();
		this.controllers.put(StateValue.INITIAL, new StartController(this.session));
		this.controllers.put(StateValue.IN_GAME, new PlayController(this.session));
		this.controllers.put(StateValue.RESUME, new ResumeController(this.session));
		this.controllers.put(StateValue.EXIT, null);
    }

    void play() {
		Controller controller;
		do {
			controller = this.controllers.get(this.session.getValueState());
			if (controller != null) {
				controller.control();
			}
		} while (controller != null);
	}

    public static void main(String[] args) {
		new TicTacToe().play();
	}
}