package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Error;
import usantatecla.tictactoe.models.Player;

class MachinePlayerView extends PlayerView {

    MachinePlayerView(Player player) {
		super(player);
	}

	@Override
	Coordinate readCoordinateToPut() {
        Coordinate coordinate = new Coordinate();
		Error error;
		do {
			coordinate.random();
			error = this.getPutCoordinateError(coordinate);
		} while (error != null);
		return coordinate;
    }

	@Override
    Coordinate[] readCoordinatesToMove() {
        Coordinate originCoordinate = new Coordinate();
		Error error;
		do {
			originCoordinate.random();
			error = this.getMoveOriginCoordinateError(originCoordinate);
		} while (error != null);
		Coordinate targetCoordinate = new Coordinate();
		do {
			targetCoordinate.random();
			error = this.getMoveTargetCoordinateError(originCoordinate, targetCoordinate);
		} while (error != null);
		Coordinate[] coordinates = new Coordinate[2];
        coordinates[0] = originCoordinate;
        coordinates[1] = targetCoordinate;
		return coordinates;
    }
    
}