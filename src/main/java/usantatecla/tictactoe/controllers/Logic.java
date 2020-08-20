package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.PlayerType;

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

	public boolean isBoardComplete() {
		return this.playController.isBoardComplete();
	}

	public PlayerType getTypeOfTokenPlayerFromTurn() {
		return this.playController.getTypeOfTokenPlayerFromTurn();
	}

	public Error getErrorsPutCoordinate(int row, int column) {
		return this.playController.getErrorsPutCoordinate(row, column);
	}

	public Error getErrorsMoveOriginCoordinate(int originRow, int originColumn) {
		return this.playController.getErrorsMoveOriginCoordinate(originRow, originColumn);
	}

	public Error getErrorsMoveTargetCoordinate(int originRow, int originColumn, int targetRow, int targetColumn) {
		return this.playController.getErrorsMoveTargetCoordinate(originRow, originColumn, targetRow, targetColumn);
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

	public char getTokenChar(int row, int column) {
		return this.playController.getTokenChar(row, column);
	}

	public boolean isEmptyToken(int row, int column) {
		return this.playController.isEmptyToken(row, column);
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
    
}