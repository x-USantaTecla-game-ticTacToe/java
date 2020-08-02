package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Player;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.views.PlayerView;

class PlayView {

    Logic logic;
    
    PlayView(Logic logic) {
        this.logic = logic;
    }

    boolean interact() {
        Player player = this.logic.getTokenPlayerFromTurn();
        PlayerView playerView = player.getType() == PlayerType.USER_PLAYER ? new UserPlayerView(player) : 
                                                                             new MachinePlayerView(player);
        if (!this.logic.isBoardComplete()) {
            Coordinate coordinate = playerView.readCoordinateToPut();
            this.logic.putTokenPlayerFromTurn(coordinate);
        } else {
            Coordinate[] coordinates = playerView.readCoordinatesToMove();
            this.logic.moveTokenPlayerFromTurn(coordinates);
        }
        this.logic.changeTurn();
        new BoardView(this.logic.getBoard()).write();
        return this.logic.isTicTacToe();
    }
}