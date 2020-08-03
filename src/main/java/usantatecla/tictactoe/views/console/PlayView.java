package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.views.PlayerView;

class PlayView {

    PlayController playController;

    PlayView(PlayController playController) {
        this.playController = playController;
    }

    boolean interact() {
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
        this.playController.changeTurn();
        boolean isTicTacToe = this.playController.isTicTacToe();
        if (isTicTacToe) {
            new BoardView(this.playController).write();
        }
        return isTicTacToe;
    }
}