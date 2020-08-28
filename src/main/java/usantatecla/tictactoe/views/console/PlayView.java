package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;
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
            Coordinate coordinate = playerView.readCoordinateToPut();
            this.playController.putTokenPlayerFromTurn(coordinate);
        } else {
            Coordinate[] coordinates = playerView.readCoordinatesToMove();
            this.playController.moveTokenPlayerFromTurn(coordinates[0], coordinates[1]);
        }
        new BoardView(this.playController).write();
        if (this.playController.isTicTacToe()) {
            new ResultView().writeln(this.playController.getValueFromTurn());
            return true;
        }
        this.playController.changeTurn();
        return false;
    }
}