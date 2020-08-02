package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Board;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Player;
import usantatecla.tictactoe.types.Token;

public class Logic {
    
    private Game game;
	
	private StartController startController;

	private PlayController playController;

	private ResultController resultController;

	public Logic() {
		this.game = new Game();
		this.startController = new StartController(this.game);
		this.playController = new PlayController(this.game);
		this.resultController = new ResultController(this.game);
    }

    public void createPlayers(int numberOfUsers) {
		this.startController.createPlayers(numberOfUsers);
	}
    
    public Player getTokenPlayerFromTurn() {
		return this.playController.getTokenPlayerFromTurn();
	}

	public boolean isBoardComplete() {
		return this.playController.isBoardComplete();
	}

	public void putTokenPlayerFromTurn(Coordinate coordinate) {
		this.playController.putTokenPlayerFromTurn(coordinate);
	}

	public void moveTokenPlayerFromTurn(Coordinate[] coordinates) {
		this.playController.moveTokenPlayerFromTurn(coordinates);
	}

	public void changeTurn() {
		this.playController.changeTurn();
	}

	public Token getToken(int row, int column) {
		return this.playController.getToken(row, column);
	}

	public int getCoordinateDimension() {
		return this.playController.getCoordinateDimension();
	}

	public boolean isTicTacToe() {
		return this.playController.isTicTacToe();
    }
    
    public int getOtherValueFromTurn() {
		return this.resultController.getOtherValueFromTurn();
	}
	
	public Board getBoard() {
        return this.startController.getBoard();
    }
    
}