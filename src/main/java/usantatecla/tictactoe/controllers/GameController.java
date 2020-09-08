package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.views.ErrorView;
import usantatecla.tictactoe.views.GameView;
import usantatecla.tictactoe.views.UserPlayerView;

class GameController {
	static final String ENTER_COORDINATE_TO_PUT = "Enter a coordinate to put a token:";
	static final String ENTER_COORDINATE_TO_REMOVE = "Enter a coordinate to remove a token:";

	private GameView gameView;

	private Game game;

	GameController() {
		this.game = new Game();
		this.gameView = new GameView();
	}

	Game getGame() {
		return this.game;
	}

	void doMovement() {
		Error error;
		if (!this.game.isBoardComplete()) {
			Coordinate coordinate;
			do {
				coordinate = this.readCoordinateToPut();
				error = this.game.putTokenPlayerFromTurn(coordinate);
				if (error != null && this.isUserPlayerType()) {
					new ErrorView(error).writeln();
				}
			} while (error != null);
		} else {
			Coordinate[] coordinates = new Coordinate[2];
			do {
				coordinates = this.readCoordinateToMove();
				error = this.game.moveTokenPlayerFromTurn(coordinates);
				if (error != null && this.isUserPlayerType()) {
					new ErrorView(error).writeln();
				}
			} while (error != null);
		}
	}

	private boolean isUserPlayerType() {
		return this.game.getTypeOfTokenPlayerFromTurn() == PlayerType.USER_PLAYER;
	}

	private Coordinate readCoordinateToPut() {
		Coordinate coordinate;
		do {
			coordinate = this.isUserPlayerType()
					? new UserPlayerView().readCoordinate(GameController.ENTER_COORDINATE_TO_PUT)
					: this.generateRandomCoordinate();
			if (!coordinate.isValid() && this.isUserPlayerType()) {
				new ErrorView(Error.WRONG_COORDINATES).writeln();
			}
		} while (!coordinate.isValid());
		return coordinate;
	}

	private Coordinate generateRandomCoordinate() {
		Coordinate coordinateRandom = new Coordinate();
		coordinateRandom.random();
		return coordinateRandom;
	}

	private Coordinate[] readCoordinateToMove() {
		Coordinate[] coordinates = new Coordinate[2];
		do {
			coordinates[0] = this.isUserPlayerType()
					? new UserPlayerView().readCoordinate(GameController.ENTER_COORDINATE_TO_REMOVE)
					: this.generateRandomCoordinate();
			assert coordinates[0].isValid();
			if (!coordinates[0].isValid() && this.isUserPlayerType()) {
				new ErrorView(Error.WRONG_COORDINATES).writeln();
			}
		} while (!coordinates[0].isValid());
		do {
			coordinates[1] = this.isUserPlayerType()
					? new UserPlayerView().readCoordinate(GameController.ENTER_COORDINATE_TO_PUT)
					: this.generateRandomCoordinate();
			assert coordinates[1].isValid();
			if (!coordinates[1].isValid() && this.isUserPlayerType()) {
				new ErrorView(Error.WRONG_COORDINATES).writeln();
			}
		} while (!coordinates[1].isValid());
		return coordinates;
	}

	void writeBoard() {
		this.gameView.writeSeparator();
		for (int i = 0; i < this.game.getCoordinateDimension(); i++) {
			this.printRowBoard(i);
        }
        this.gameView.writeSeparator();
	}

	private void printRowBoard(int row) {
        this.gameView.writeVerticalLineLeft();
		for (int j = 0; j < this.game.getCoordinateDimension(); j++) {
			this.printSquareBoard(new Coordinate(row, j));
		}
		this.gameView.writeLineBreak();
	}

	private void printSquareBoard(Coordinate coordinate) {
		if (this.game.isEmptyToken(coordinate)) {
           	this.gameView.writeEmpty();
		} else {
			this.gameView.writeToken(this.game.getTokenChar(coordinate));
        }
        this.gameView.writeVerticalLineCentered();
	}
}