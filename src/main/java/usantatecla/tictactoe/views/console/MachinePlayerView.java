package usantatecla.tictactoe.views.console;

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
			error = controlErrorsPutCoordinate(coordinate[0], coordinate[1]);
		} while (error != null);
		return coordinate;
	}

	@Override
	public int[][] readCoordinatesToMove() {
		int[] originCoordinate = new int[2];
		Error error;
		do {
			originCoordinate = this.logic.generateRandomCoordinate();
			error = controlErrorsMoveOriginCoordinate(originCoordinate[0], originCoordinate[1]);
		} while (error != null);
		int[] targetCoordinate = new int[2];
		do {
			targetCoordinate = this.logic.generateRandomCoordinate();
			error = controlErrorsMoveTargetCoordinate(originCoordinate[0], originCoordinate[1], targetCoordinate[0],
					targetCoordinate[1]);
		} while (error != null);
		int[][] coordinates = new int[2][2];
		coordinates[0] = originCoordinate;
		coordinates[1] = targetCoordinate;
		return coordinates;
	}

}