package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.events.MoveEvent;
import usantatecla.tictactoe.events.NewGameEvent;
import usantatecla.tictactoe.events.RedoEvent;
import usantatecla.tictactoe.events.UndoEvent;
import usantatecla.tictactoe.models.TicTacToe;
import usantatecla.tictactoe.views.TicTacToeView;
import usantatecla.utils.Event;
import usantatecla.utils.Observed;
import usantatecla.utils.Observer;

class TicTacToeController implements Observer {
    
    private GameController gameController;
	
	private TicTacToe tictactoe;
	
	private TicTacToeView tictactoeView;
	
	TicTacToeController() {
		this.clear();
	}
	
	void clear() {
		this.gameController = new GameController();
		this.tictactoe = new TicTacToe(this.gameController.getGame());
		this.tictactoeView = new TicTacToeView(this.tictactoe, this);
		this.tictactoeView.addObserver(this);
		this.tictactoe.addObserver(this.tictactoeView);	
	}
	
	void play() {
        int numberOfUsers = new StartController().read();
        this.tictactoe.createPlayers(numberOfUsers);
		this.gameController.writeBoard();
		this.tictactoe.registry();
		this.tictactoeView.write();
	}

	
	public void update(Observed observed, Event event) {
		if (event instanceof MoveEvent) {
			this.gameController.doMovement();
            this.tictactoe.registry();
            this.gameController.writeBoard();
		} else if (event instanceof UndoEvent) {
            this.tictactoe.undo();
            this.gameController.writeBoard();			
		} else if (event instanceof RedoEvent) {
            this.tictactoe.redo();
            this.gameController.writeBoard();
		} else if (event instanceof NewGameEvent) {
			this.clear();
			this.tictactoe.newGame();
			this.play();
		}
	}

	public static void main(String[] args) {
		new TicTacToeController().play();
	}
}
