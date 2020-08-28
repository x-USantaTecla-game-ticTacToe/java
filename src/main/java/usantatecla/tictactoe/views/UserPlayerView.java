package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Error;
import usantatecla.tictactoe.models.Player;

class UserPlayerView extends PlayerView {
    static final String ENTER_COORDINATE_TO_PUT = "Enter a coordinate to put a token:";
    static final String ENTER_COORDINATE_TO_REMOVE = "Enter a coordinate to remove a token:";

    UserPlayerView(Player player) {
		super(player);
	}
    
    @Override
    Coordinate readCoordinateToPut() {
        Coordinate coordinate;
		Error error;
		do {
			coordinate = new CoordinateView().read(ENTER_COORDINATE_TO_PUT);
			error = this.getPutCoordinateError(coordinate);
			if (error != null) {
				new ErrorView(error).writeln();
			}
        } while (error != null);
        return coordinate;
    }

    @Override
    Coordinate[] readCoordinatesToMove() {
        Coordinate originCoordinate;
		Error error;
		do {
			originCoordinate = new CoordinateView().read(ENTER_COORDINATE_TO_REMOVE);
			error = this.getMoveOriginCoordinateError(originCoordinate);
			if (error != null) {
				new ErrorView(error).writeln();
			}
        } while (error != null);
        Coordinate targetCoordinate;
        do {
			targetCoordinate = new CoordinateView().read(ENTER_COORDINATE_TO_PUT);
			error = this.getMoveTargetCoordinateError(originCoordinate, targetCoordinate);
			if (error != null) {
				new ErrorView(error).writeln();
			}
        } while (error != null);
        Coordinate[] coordinates = new Coordinate[2];
        coordinates[0] = originCoordinate;
        coordinates[1] = targetCoordinate;
        return coordinates;
    }
}