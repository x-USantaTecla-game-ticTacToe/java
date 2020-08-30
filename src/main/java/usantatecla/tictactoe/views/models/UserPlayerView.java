package usantatecla.tictactoe.views.models;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.types.Error;

public class UserPlayerView extends PlayerView {
    static final String ENTER_COORDINATE_TO_PUT = "Enter a coordinate to put a token:";
    static final String ENTER_COORDINATE_TO_REMOVE = "Enter a coordinate to remove a token:";

    public UserPlayerView(PlayController playController) {
        super(playController);
    }

    @Override
    public Coordinate readCoordinateToPut() {
        Coordinate coordinate;
        Error error;
        do {
            coordinate = new CoordinateView(this.playController).read(ENTER_COORDINATE_TO_PUT);
            error = this.getPutCoordinateError(coordinate);
            if (error != null) {
                new ErrorView(error).writeln();
            }
        } while (error != null);
        return coordinate;
    }

    @Override
    public Coordinate[] readCoordinatesToMove() {
        Coordinate[] coordinates = new Coordinate[2];
        Error error;
        do {
            coordinates[0] = new CoordinateView(this.playController).read(ENTER_COORDINATE_TO_REMOVE);
            error = this.getMoveOriginCoordinateError(coordinates[0]);
            if (error != null) {
                new ErrorView(error).writeln();
            }
        } while (error != null);
        do {
            coordinates[1] = new CoordinateView(this.playController).read(ENTER_COORDINATE_TO_PUT);
            error = this.getMoveTargetCoordinateError(coordinates[0], coordinates[1]);
            if (error != null) {
                new ErrorView(error).writeln();
            }
        } while (error != null);
        return coordinates;
    }
}