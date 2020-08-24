package usantatecla.tictactoe.views.menus;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.views.models.BoardView;
import usantatecla.tictactoe.views.models.GameView;
import usantatecla.tictactoe.views.models.MachinePlayerView;
import usantatecla.tictactoe.views.models.MessageView;
import usantatecla.tictactoe.views.models.PlayerView;
import usantatecla.tictactoe.views.models.UserPlayerView;

public class MovementCommand extends Command {

    MovementCommand(PlayController playController) {
        super(MessageView.PROPOSE_COMMAND.getMessage(), playController);
    }

    @Override
    protected void execute() {
        new BoardView((PlayController) this.acceptorController).write();
        PlayerView playerView = ((PlayController) this.acceptorController).getTypeOfTokenPlayerFromTurn() == PlayerType.USER_PLAYER
                ? new UserPlayerView(((PlayController) this.acceptorController))
                : new MachinePlayerView(((PlayController) this.acceptorController));
        if (!((PlayController) this.acceptorController).isBoardComplete()) {
            int[] coordinate = playerView.readCoordinateToPut();
            ((PlayController) this.acceptorController).putTokenPlayerFromTurn(coordinate[0], coordinate[1]);
        } else {
            int[][] coordinates = playerView.readCoordinatesToMove();
            ((PlayController) this.acceptorController).moveTokenPlayerFromTurn(coordinates[0][0], coordinates[0][1], coordinates[1][0], coordinates[1][1]);
        }
        new GameView(((PlayController) this.acceptorController));
    }

    @Override
	protected boolean isActive() {
		return true;
	}
    
}