package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.types.PlayerType;

public class MovementCommand extends Command {

    MovementCommand(PlayController playController) {
		super(MessageView.PROPOSE_COMMAND.getMessage(), playController);
	}

    @Override
    protected void execute() {
        new BoardView(this.playController).write();
        PlayerView playerView = this.playController.getTypeOfTokenPlayerFromTurn() == PlayerType.USER_PLAYER
                ? new UserPlayerView(this.playController)
                : new MachinePlayerView(this.playController);
        if (!this.playController.isBoardComplete()) {
            int[] coordinate = playerView.readCoordinateToPut();
            this.playController.putTokenPlayerFromTurn(coordinate[0], coordinate[1]);
        } else {
            int[][] coordinates = playerView.readCoordinatesToMove();
            this.playController.moveTokenPlayerFromTurn(coordinates[0][0], coordinates[0][1], coordinates[1][0], coordinates[1][1]);
        }
        new GameView(this.playController);
    }

    @Override
	protected boolean isActive() {
		return true;
	}
    
}