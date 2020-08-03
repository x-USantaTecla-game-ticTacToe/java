package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.views.PlayerView;

class PlayView {

    void interact(PlayController playController) {
        new BoardView(playController).write();
        PlayerView playerView = playController.getTypeOfTokenPlayerFromTurn() == PlayerType.USER_PLAYER
                ? new UserPlayerView(playController)
                : new MachinePlayerView(playController);
        if (!playController.isBoardComplete()) {
            int[] coordinate = playerView.readCoordinateToPut();
            playController.putTokenPlayerFromTurn(coordinate[0], coordinate[1]);
        } else {
            int[][] coordinates = playerView.readCoordinatesToMove();
            playController.moveTokenPlayerFromTurn(coordinates[0][0], coordinates[0][1], coordinates[1][0], coordinates[1][1]);
        }
        playController.changeTurn();
        if (playController.isTicTacToe()) {
            new BoardView(playController).write();
            playController.continueState();
        }
    }
}