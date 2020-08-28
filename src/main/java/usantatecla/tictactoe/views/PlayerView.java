package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Error;
import usantatecla.tictactoe.models.Player;

public abstract class PlayerView {

    protected Player player;

    public PlayerView(Player player) {
        this.player = player;
    }
  
    public abstract Coordinate readCoordinateToPut();
    public abstract Coordinate[] readCoordinatesToMove();

    public Error getPutCoordinateError(Coordinate coordinate) {
        return this.player.getPutCoordinateError(coordinate);
	}

	public Error getMoveOriginCoordinateError(Coordinate originCoordinate) {
		return this.player.getMoveOriginCoordinateError(originCoordinate);
	}

	public Error getMoveTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
		return this.player.getMoveTargetCoordinateError(originCoordinate, targetCoordinate);
	}
}