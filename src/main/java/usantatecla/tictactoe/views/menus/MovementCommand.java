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
        PlayController playController = (PlayController) this.acceptorController;
        new BoardView(playController).write();
        PlayerView playerView = (playController).getTypeOfTokenPlayerFromTurn() == PlayerType.USER_PLAYER
                ? new UserPlayerView((playController))
                : new MachinePlayerView((playController));
        if (!(playController).isBoardComplete()) {
            Coordinate coordinate = playerView.readCoordinateToPut();
            (playController).putTokenPlayerFromTurn(coordinate);
        } else {
            Coordinate[] coordinates = playerView.readCoordinatesToMove();
            (playController).moveTokenPlayerFromTurn(coordinates);
        }
        new GameView((playController));
    }

    @Override
	protected boolean isActive() {
		return true;
	}
    
}