package usantatecla.tictactoe.views.models;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.types.Error;

public abstract class PlayerView {

    protected PlayController playController;

    public PlayerView(PlayController playController) {
        this.playController = playController;
    }
  
    public abstract int[] readCoordinateToPut();
    public abstract int[][] readCoordinatesToMove();

    public Error controlErrorsPutCoordinate(int row, int column) {
        return this.playController.controlErrorsPutCoordinate(row, column);
	}

	public Error controlErrorsMoveOriginCoordinate(int originRow, int originColumn) {
		return this.playController.controlErrorsMoveOriginCoordinate(originRow, originColumn);
	}

	public Error controlErrorsMoveTargetCoordinate(int originRow, int originColumn, int targetRow, int targetColumn) {
		return this.playController.controlErrorsMoveTargetCoordinate(originRow, originColumn, targetRow, targetColumn);
	}
}