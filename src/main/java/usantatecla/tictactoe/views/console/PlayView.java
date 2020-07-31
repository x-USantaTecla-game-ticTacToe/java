package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Player;
import usantatecla.tictactoe.models.PlayerType;
import usantatecla.tictactoe.views.PlayerView;

class PlayView {

    void interact(PlayController playController) {
        Player player = playController.getTokenPlayerFromTurn();
        PlayerView playerView = player.getType() == PlayerType.USER_PLAYER ? new UserPlayerView(player) : 
                                                                             new MachinePlayerView(player);
        if (!playController.isBoardComplete()) {
            Coordinate coordinate = playerView.readCoordinateToPut();
            playController.putTokenPlayerFromTurn(coordinate);
        } else {
            Coordinate[] coordinates = playerView.readCoordinatesToMove();
            playController.moveTokenPlayerFromTurn(coordinates);
        }
        playController.changeTurn();
        new BoardView(playController.getBoard()).write();
        playController.isTicTacToe();
    }
}