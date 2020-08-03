package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.views.PlayerView;

class PlayView {

    Logic logic;

    PlayView(Logic logic) {
        this.logic = logic;
    }

    boolean interact() {
        new BoardView(this.logic).write();
        PlayerView playerView = this.logic.getTypeOfTokenPlayerFromTurn() == PlayerType.USER_PLAYER
                ? new UserPlayerView(this.logic)
                : new MachinePlayerView(this.logic);
        if (!this.logic.isBoardComplete()) {
            int[] coordinate = playerView.readCoordinateToPut();
            this.logic.putTokenPlayerFromTurn(coordinate[0], coordinate[1]);
        } else {
            int[][] coordinates = playerView.readCoordinatesToMove();
            this.logic.moveTokenPlayerFromTurn(coordinates[0][0], coordinates[0][1], coordinates[1][0], coordinates[1][1]);
        }
        this.logic.changeTurn();
        boolean isTicTacToe = this.logic.isTicTacToe();
        if (isTicTacToe) {
            new BoardView(this.logic).write();
        }
        return isTicTacToe;
    }
}