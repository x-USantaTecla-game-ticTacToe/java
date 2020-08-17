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

    Error getErrorsPutCoordinate(Coordinate coordinate) {
        return this.player.getErrorsPutCoordinate(coordinate);
	}

	Error getErrorsMoveOriginCoordinate(Coordinate originCoordinate) {
		return this.player.getErrorsMoveOriginCoordinate(originCoordinate);
	}

	Error getErrorsMoveTargetCoordinate(Coordinate originCoordinate, Coordinate targetCoordinate) {
		return this.player.getErrorsMoveTargetCoordinate(originCoordinate, targetCoordinate);
	}
}