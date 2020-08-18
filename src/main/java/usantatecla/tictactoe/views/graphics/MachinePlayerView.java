package usantatecla.tictactoe.views.graphics;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.views.PlayerView;

class MachinePlayerView extends PlayerView {

	MachinePlayerView(Logic logic) {
		super(logic);
	}

	@Override
	public int[] readCoordinateToPut() {
		int[] coordinate = new int[2];
		Error error;
		do {
			coordinate = this.logic.generateRandomCoordinate();
			error = getErrorsPutCoordinate(coordinate[0], coordinate[1]);
		} while (error != null);
		return coordinate;
	}

	@Override
	public int[][] readCoordinatesToMove() {
		int[][] coordinates = new int[2][2];
		Error error;
		do {
			coordinates[0] = this.logic.generateRandomCoordinate();
			error = getErrorsMoveOriginCoordinate(coordinates[0][0], coordinates[0][1]);
		} while (error != null);
		do {
			coordinates[1] = this.logic.generateRandomCoordinate();
			error = getErrorsMoveTargetCoordinate(coordinates[0][0], coordinates[0][1], coordinates[1][0], coordinates[1][1]);
		} while (error != null);
		return coordinates;
	}

}