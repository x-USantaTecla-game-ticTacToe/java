package usantatecla.tictactoe.views.console;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Player;
import usantatecla.tictactoe.models.PlayerType;
import usantatecla.tictactoe.models.Token;

public class MachinePlayerViewTest {

    private Game game;

    private MachinePlayerView machinePlayerView;

    public MachinePlayerViewTest() {
        this.game = new Game();
        this.game.createPlayers(0);
        this.machinePlayerView = new MachinePlayerView(new Player(Token.TOKEN_X, this.game.getBoard(), PlayerType.MACHINE_PLAYER));
    }

    @Test
    public void testGivenNewCoordinateViewWhenReadCoordinateThenIsCorrect() {
        Coordinate coordinate = this.machinePlayerView.readCoordinateToPut();
        assertNotNull(coordinate);
    }

    @Test
    public void testGivenNewCoordinateViewWhenReadCoordinateThenIsCorrec() {
        Coordinate coordinate1 = this.machinePlayerView.readCoordinateToPut();
        this.game.putTokenPlayerFromTurn(coordinate1);
        Coordinate coordinate2 = this.machinePlayerView.readCoordinateToPut();
        this.game.putTokenPlayerFromTurn(coordinate2);
        Coordinate[] coordinates = this.machinePlayerView.readCoordinatesToMove();
        assertNotNull(coordinates[0]);
        assertNotNull(coordinates[1]);
    }
    
}