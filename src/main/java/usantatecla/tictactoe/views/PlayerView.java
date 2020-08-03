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

    public Error controlErrorsPutCoordinate(int row, int column) {
        return this.logic.controlErrorsPutCoordinate(row, column);
	}

	public Error controlErrorsMoveOriginCoordinate(int originRow, int originColumn) {
		return this.logic.controlErrorsMoveOriginCoordinate(originRow, originColumn);
	}

	public Error controlErrorsMoveTargetCoordinate(int originRow, int originColumn, int targetRow, int targetColumn) {
		return this.logic.controlErrorsMoveTargetCoordinate(originRow, originColumn, targetRow, targetColumn);
	}
}