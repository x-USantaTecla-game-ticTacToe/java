package usantatecla.tictactoe.views.console;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.State;

public class MachinePlayerViewTest {

    private Game game;

    private MachinePlayerView machinePlayerView;

    public MachinePlayerViewTest() {
        this.game = new Game();
        this.game.createPlayers(0);
        this.machinePlayerView = new MachinePlayerView(new PlayController(this.game, new State()));
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