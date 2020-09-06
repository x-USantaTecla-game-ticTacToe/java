package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.views.ErrorView;
import usantatecla.tictactoe.views.UserPlayerView;

public class MovementController extends InGameController {
	static final String ENTER_COORDINATE_TO_PUT = "Enter a coordinate to put a token:";
	static final String ENTER_COORDINATE_TO_REMOVE = "Enter a coordinate to remove a token:";

	public MovementController(Session session) {
		super(session);
	}

	@Override
	public void inGameControl() {
		Error error;
		if (!this.session.isBoardComplete()) {
			Coordinate coordinate;
			do {
				coordinate = this.readCoordinateToPut();
				error = this.session.putTokenPlayerFromTurn(coordinate);
				if (error != null && this.isUserPlayerType()) {
					new ErrorView(error).writeln();
				}
			} while (error != null);
		} else {
			Coordinate[] coordinates = new Coordinate[2];
			do {
				coordinates = this.readCoordinateToMove();
				error = this.session.moveTokenPlayerFromTurn(coordinates);
				if (error != null && this.isUserPlayerType()) {
					new ErrorView(error).writeln();
				}
			} while (error != null);
		}
	}

	private boolean isUserPlayerType() {
		return this.session.getTypeOfTokenPlayerFromTurn() == PlayerType.USER_PLAYER;
	}

	private Coordinate readCoordinateToPut() {
		Coordinate coordinate;
		do {
			coordinate = this.isUserPlayerType()
					? new UserPlayerView().readCoordinate(MovementController.ENTER_COORDINATE_TO_PUT)
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
					? new UserPlayerView().readCoordinate(MovementController.ENTER_COORDINATE_TO_REMOVE)
					: this.generateRandomCoordinate();
			assert coordinates[0].isValid();
			if (!coordinates[0].isValid() && this.isUserPlayerType()) {
				new ErrorView(Error.WRONG_COORDINATES).writeln();
			}
		} while (!coordinates[0].isValid());
		do {
			coordinates[1] = this.isUserPlayerType()
					? new UserPlayerView().readCoordinate(MovementController.ENTER_COORDINATE_TO_PUT)
					: this.generateRandomCoordinate();
			assert coordinates[1].isValid();
			if (!coordinates[1].isValid() && this.isUserPlayerType()) {
				new ErrorView(Error.WRONG_COORDINATES).writeln();
			}
		} while (!coordinates[1].isValid());
		return coordinates;
	}
}