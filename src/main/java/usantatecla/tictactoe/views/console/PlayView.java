package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.views.PlayerView;

class PlayView {

    void interact(PlayController playController) {
        new BoardView(playController).write();
        PlayerView playerView = playController.getTypeOfTokenPlayerFromTurn() == PlayerType.USER_PLAYER
                ? new UserPlayerView(playController)
                : new MachinePlayerView(playController);
        if (!playController.isBoardComplete()) {
            Coordinate coordinate = playerView.readCoordinateToPut();
            playController.putTokenPlayerFromTurn(coordinate);
        } else {
            Coordinate[] coordinates = playerView.readCoordinatesToMove();
            playController.moveTokenPlayerFromTurn(coordinates[0], coordinates[1]);
        }
        if (playController.isTicTacToe()) {
            new BoardView(playController).write();
            new ResultView().writeln(playController.getValueFromTurn());
            playController.continueState();
        } else {
            playController.changeTurn();
        }
    }
}