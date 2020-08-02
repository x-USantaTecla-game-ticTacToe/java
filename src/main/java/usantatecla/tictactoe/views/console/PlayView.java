package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Player;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.views.PlayerView;

class PlayView {

    PlayController playController;
    
    PlayView(PlayController playController) {
        this.playController = playController;
    }

    boolean interact() {
        new BoardView(this.playController).write();
        Player player = this.playController.getTokenPlayerFromTurn();
        PlayerView playerView = player.getType() == PlayerType.USER_PLAYER ? new UserPlayerView(player) : 
                                                                             new MachinePlayerView(player);
        if (!this.playController.isBoardComplete()) {
            Coordinate coordinate = playerView.readCoordinateToPut();
            this.playController.putTokenPlayerFromTurn(coordinate);
        } else {
            Coordinate[] coordinates = playerView.readCoordinatesToMove();
            this.playController.moveTokenPlayerFromTurn(coordinates);
        }
        this.playController.changeTurn();
        boolean isTicTacToe = this.playController.isTicTacToe();
        if (isTicTacToe) {
            new BoardView(this.playController).write();
        }
        return isTicTacToe;
    }
}