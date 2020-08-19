package usantatecla.tictactoe.views.console;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;

public class MachinePlayerViewTest {

    private Game game;

    private MachinePlayerView machinePlayerView;

    public MachinePlayerViewTest() {
        this.game = new Game();
        this.game.createPlayers(0);
        this.machinePlayerView = new MachinePlayerView(new PlayController(this.game));
    }

    @Test
    public void testGivenNewCoordinateViewWhenReadCoordinateThenIsCorrect() {
        int[] coordinate = this.machinePlayerView.readCoordinateToPut();
        assertNotNull(coordinate);
    }

    @Test
    public void testGivenNewCoordinateViewWhenReadCoordinateThenIsCorrec() {
        int[] coordinate1 = this.machinePlayerView.readCoordinateToPut();
        this.game.putTokenPlayerFromTurn(new Coordinate(coordinate1[0], coordinate1[1]));
        int[] coordinate2 = this.machinePlayerView.readCoordinateToPut();
        this.game.putTokenPlayerFromTurn(new Coordinate(coordinate2[0], coordinate2[1]));
        int[][] coordinates = this.machinePlayerView.readCoordinatesToMove();
        assertNotNull(coordinates[0]);
        assertNotNull(coordinates[1]);
    }
    
}