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

    public Error getErrorsPutCoordinate(Coordinate coordinate) {
        return this.player.getErrorsPutCoordinate(coordinate);
	}

	public Error getErrorsMoveOriginCoordinate(Coordinate originCoordinate) {
		return this.player.getErrorsMoveOriginCoordinate(originCoordinate);
	}

	public Error getErrorsMoveTargetCoordinate(Coordinate originCoordinate, Coordinate targetCoordinate) {
		return this.player.getErrorsMoveTargetCoordinate(originCoordinate, targetCoordinate);
	}
}