package usantatecla.tictactoe.views.menus;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;
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
            Coordinate coordinate = playerView.readCoordinateToPut();
            ((PlayController) this.acceptorController).putTokenPlayerFromTurn(coordinate);
        } else {
            Coordinate[] coordinates = playerView.readCoordinatesToMove();
            ((PlayController) this.acceptorController).moveTokenPlayerFromTurn(coordinates);
        }
        new GameView(((PlayController) this.acceptorController));
    }

    @Override
	protected boolean isActive() {
		return true;
	}
    
}