package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.types.Error;

public abstract class PlayerView {

    protected PlayController playController;

    public PlayerView(PlayController playController) {
        this.playController = playController;
    }
  
    public abstract int[] readCoordinateToPut();
    public abstract int[][] readCoordinatesToMove();

    public Error getErrorsPutCoordinate(int row, int column) {
        return this.playController.getErrorsPutCoordinate(row, column);
	}

	public Error getErrorsMoveOriginCoordinate(int originRow, int originColumn) {
		return this.playController.getErrorsMoveOriginCoordinate(originRow, originColumn);
	}

	public Error getErrorsMoveTargetCoordinate(int originRow, int originColumn, int targetRow, int targetColumn) {
		return this.playController.getErrorsMoveTargetCoordinate(originRow, originColumn, targetRow, targetColumn);
	}
}