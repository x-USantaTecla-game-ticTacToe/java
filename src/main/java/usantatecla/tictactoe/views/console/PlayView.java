package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Player;
import usantatecla.tictactoe.models.PlayerType;
import usantatecla.tictactoe.views.PlayerView;

class PlayView {

    Game game;
    
    PlayView(Game game) {
        this.game = game;
    }

    boolean interact() {
        Player player = this.game.getTokenPlayerFromTurn();
        PlayerView playerView = player.getType() == PlayerType.USER_PLAYER ? new UserPlayerView(player) : 
                                                                             new MachinePlayerView(player);
        if (!this.game.isBoardComplete()) {
            Coordinate coordinate = playerView.readCoordinateToPut();
            this.game.putTokenPlayerFromTurn(coordinate);
        } else {
            Coordinate[] coordinates = playerView.readCoordinatesToMove();
            this.game.moveTokenPlayerFromTurn(coordinates);
        }
        new BoardView(this.game.getBoard()).write();
        if (this.game.isTicTacToe()) {
            new ResultView().writeln(this.game.getValueFromTurn());
            return true;
        }
        this.game.changeTurn();
        return false;
    }
}