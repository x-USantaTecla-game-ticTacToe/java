package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.models.Coordinate;
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
            Coordinate coordinate = playerView.readCoordinateToPut();
            this.logic.putTokenPlayerFromTurn(coordinate);
        } else {
            Coordinate[] coordinates = playerView.readCoordinatesToMove();
            this.logic.moveTokenPlayerFromTurn(coordinates[0], coordinates[1]);
        }
        new BoardView(this.logic).write();
        if (this.logic.isTicTacToe()) {
            new ResultView().writeln(this.logic.getValueFromTurn());
            return true;
        }
        this.logic.changeTurn();
        return false;
    }
}