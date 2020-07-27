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

    Error controlErrorsPutCoordinate(Coordinate coordinate) {
        return this.player.controlErrorsPutCoordinate(coordinate);
	}

	Error controlErrorsMoveOriginCoordinate(Coordinate originCoordinate) {
		return this.player.controlErrorsMoveOriginCoordinate(originCoordinate);
	}

	Error controlErrorsMoveTargetCoordinate(Coordinate originCoordinate, Coordinate targetCoordinate) {
		return this.player.controlErrorsMoveTargetCoordinate(originCoordinate, targetCoordinate);
	}
}