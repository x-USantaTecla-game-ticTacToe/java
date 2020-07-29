package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Error;
import usantatecla.tictactoe.models.Player;
import usantatecla.tictactoe.views.PlayerView;

class UserPlayerView extends PlayerView {
    static final String ENTER_COORDINATE_TO_PUT = "Enter a coordinate to put a token:";
    static final String ENTER_COORDINATE_TO_REMOVE = "Enter a coordinate to remove a token:";

    UserPlayerView(Player player) {
		super(player);
	}
    
    @Override
    public Coordinate readCoordinateToPut() {
        Coordinate coordinate;
		Error error;
		do {
			coordinate = new CoordinateView().read(ENTER_COORDINATE_TO_PUT);
			error = controlErrorsPutCoordinate(coordinate);
			if (error != null) {
				new ErrorView(error).writeln();
			}
        } while (error != null);
        return coordinate;
    }

    @Override
    public Coordinate[] readCoordinatesToMove() {
        Coordinate originCoordinate;
		Error error;
		do {
			originCoordinate = new CoordinateView().read(ENTER_COORDINATE_TO_REMOVE);
			error = controlErrorsMoveOriginCoordinate(originCoordinate);
			if (error != null) {
				new ErrorView(error).writeln();
			}
        } while (error != null);
        Coordinate targetCoordinate;
        do {
			targetCoordinate = new CoordinateView().read(ENTER_COORDINATE_TO_PUT);
			error = controlErrorsMoveTargetCoordinate(originCoordinate, targetCoordinate);
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