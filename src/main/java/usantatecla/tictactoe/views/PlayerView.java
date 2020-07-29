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

    public Error controlErrorsPutCoordinate(Coordinate coordinate) {
        return this.player.controlErrorsPutCoordinate(coordinate);
	}

	public Error controlErrorsMoveOriginCoordinate(Coordinate originCoordinate) {
		return this.player.controlErrorsMoveOriginCoordinate(originCoordinate);
	}

	public Error controlErrorsMoveTargetCoordinate(Coordinate originCoordinate, Coordinate targetCoordinate) {
		return this.player.controlErrorsMoveTargetCoordinate(originCoordinate, targetCoordinate);
	}
}