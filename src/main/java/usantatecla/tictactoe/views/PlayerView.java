package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Error;
import usantatecla.tictactoe.models.Player;

abstract class PlayerView {

    protected Player player;

    PlayerView(Player player) {
        this.player = player;
    }
  
    abstract Coordinate readCoordinateToPut();
    abstract Coordinate[] readCoordinatesToMove();

    Error getPutCoordinateError(Coordinate coordinate) {
        return this.player.getPutCoordinateError(coordinate);
	}

	Error getMoveOriginCoordinateError(Coordinate originCoordinate) {
		return this.player.getMoveOriginCoordinateError(originCoordinate);
	}

	Error getMoveTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
		return this.player.getMoveTargetCoordinateError(originCoordinate, targetCoordinate);
	}
}