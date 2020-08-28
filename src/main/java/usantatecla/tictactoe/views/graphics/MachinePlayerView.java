package usantatecla.tictactoe.views.graphics;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.views.PlayerView;

class MachinePlayerView extends PlayerView {

	MachinePlayerView(Logic logic) {
		super(logic);
	}

	@Override
	public Coordinate readCoordinateToPut() {
		Coordinate coordinate;
		Error error;
		do {
			coordinate = this.logic.generateRandomCoordinate();
			error = getPutCoordinateError(coordinate);
		} while (error != null);
		return coordinate;
	}

	@Override
	public Coordinate[] readCoordinatesToMove() {
		Coordinate[] coordinates = new Coordinate[2];
		Error error;
		do {
			coordinates[0] = this.logic.generateRandomCoordinate();
			error = getMoveOriginCoordinateError(coordinates[0]);
		} while (error != null);
		do {
			coordinates[1] = this.logic.generateRandomCoordinate();
			error = getMoveTargetCoordinateError(coordinates[0], coordinates[1]);
		} while (error != null);
		return coordinates;
	}

}