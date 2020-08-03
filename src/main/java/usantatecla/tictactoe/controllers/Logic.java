package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Board;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Player;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.PlayerType;
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

	public PlayerType getTypeOfTokenPlayerFromTurn() {
		return this.playController.getTypeOfTokenPlayerFromTurn();
	}

	public Error controlErrorsPutCoordinate(int row, int column) {
		return this.playController.controlErrorsPutCoordinate(row, column);
	}

	public Error controlErrorsMoveOriginCoordinate(int originRow, int originColumn) {
		return this.playController.controlErrorsMoveOriginCoordinate(originRow, originColumn);
	}

	public Error controlErrorsMoveTargetCoordinate(int originRow, int originColumn, int targetRow, int targetColumn) {
		return this.playController.controlErrorsMoveTargetCoordinate(originRow, originColumn, targetRow, targetColumn);
	}

	public boolean isCoordinateValid(int row, int column) {
		return this.playController.isCoordinateValid(row, column);
	}

	public int[] generateRandomCoordinate() {
		return this.playController.generateRandomCoordinate();
	}

	public void putTokenPlayerFromTurn(int originRow, int originColumn) {
		this.playController.putTokenPlayerFromTurn(originRow, originColumn);
	}

	public void moveTokenPlayerFromTurn(int originRow, int originColumn, int targetRow, int targetColumn) {
		this.playController.moveTokenPlayerFromTurn(originRow, originColumn, targetRow, targetColumn);
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