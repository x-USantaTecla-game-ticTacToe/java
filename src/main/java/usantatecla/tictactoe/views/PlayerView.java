package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.types.Error;

public abstract class PlayerView {

    protected Logic logic;

    public PlayerView(Logic logic) {
        this.logic = logic;
    }
  
    public abstract int[] readCoordinateToPut();
    public abstract int[][] readCoordinatesToMove();

    public Error getErrorsPutCoordinate(int row, int column) {
        return this.logic.getErrorsPutCoordinate(row, column);
	}

	public Error getErrorsMoveOriginCoordinate(int originRow, int originColumn) {
		return this.logic.getErrorsMoveOriginCoordinate(originRow, originColumn);
	}

	public Error getErrorsMoveTargetCoordinate(int originRow, int originColumn, int targetRow, int targetColumn) {
		return this.logic.getErrorsMoveTargetCoordinate(originRow, originColumn, targetRow, targetColumn);
	}
}