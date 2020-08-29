package usantatecla.tictactoe.views;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Session;

public class MachinePlayerViewTest {

    private Session session;

    private MachinePlayerView machinePlayerView;

    public MachinePlayerViewTest() {
        this.session = new Session(null);
        this.session.createPlayers(0);
        this.machinePlayerView = new MachinePlayerView(new PlayController(this.session, null));
    }

    @Test
    public void testGivenNewCoordinateViewWhenReadCoordinateThenIsCorrect() {
        Coordinate coordinate = this.machinePlayerView.readCoordinateToPut();
        assertNotNull(coordinate);
    }

    @Test
    public void testGivenNewCoordinateViewWhenReadCoordinateThenIsCorrec() {
        Coordinate coordinate1 = this.machinePlayerView.readCoordinateToPut();
        this.session.putTokenPlayerFromTurn(coordinate1);
        Coordinate coordinate2 = this.machinePlayerView.readCoordinateToPut();
        this.session.putTokenPlayerFromTurn(coordinate2);
        Coordinate[] coordinates = this.machinePlayerView.readCoordinatesToMove();
        assertNotNull(coordinates[0]);
        assertNotNull(coordinates[1]);
    }
    
}