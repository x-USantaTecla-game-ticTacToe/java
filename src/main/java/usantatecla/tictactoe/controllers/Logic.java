package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.PlayerType;

public class Logic {
    
    private Game game;
	
	private StartController startController;

	private PlayController playController;

	private ResumeController resumeController;

	public Logic() {
		this.game = new Game();
		this.startController = new StartController(this.game);
		this.playController = new PlayController(this.game);
		this.resumeController = new ResumeController(this.game);
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

	public Error getPutCoordinateError(Coordinate coordinate) {
		return this.playController.getPutCoordinateError(coordinate);
	}

	public Error getMoveOriginCoordinateError(Coordinate coordinate) {
		return this.playController.getMoveOriginCoordinateError(coordinate);
	}

	public Error getMoveTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
		return this.playController.getMoveTargetCoordinateError(originCoordinate, targetCoordinate);
	}

	public boolean isCoordinateValid(Coordinate coordinate) {
		return this.playController.isCoordinateValid(coordinate);
	}

	public Coordinate generateRandomCoordinate() {
		return this.playController.generateRandomCoordinate();
	}

	public void putTokenPlayerFromTurn(Coordinate coordinate) {
		this.playController.putTokenPlayerFromTurn(coordinate);
	}

	public void moveTokenPlayerFromTurn(Coordinate originCoordinate, Coordinate targetCoordinate) {
		this.playController.moveTokenPlayerFromTurn(originCoordinate, targetCoordinate);
	}

	public void changeTurn() {
		this.playController.changeTurn();
	}

	public char getTokenChar(Coordinate coordinate) {
		return this.playController.getTokenChar(coordinate);
	}

	public boolean isEmptyToken(Coordinate coordinate) {
		return this.playController.isEmptyToken(coordinate);
	}

	public int getCoordinateDimension() {
		return this.playController.getCoordinateDimension();
	}

	public boolean isTicTacToe() {
		return this.playController.isTicTacToe();
    }
    
    public int getValueFromTurn() {
		return this.playController.getValueFromTurn();
	}

	public void newGame() {
		this.resumeController.newGame();
	}
    
}