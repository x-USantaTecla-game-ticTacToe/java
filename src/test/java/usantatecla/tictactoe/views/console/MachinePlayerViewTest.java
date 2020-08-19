package usantatecla.tictactoe.views.console;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import usantatecla.tictactoe.controllers.Logic;

public class MachinePlayerViewTest {

    private Logic logic;

    private MachinePlayerView machinePlayerView;

    public MachinePlayerViewTest() {
        this.logic = new Logic();
        this.logic.createPlayers(0);
        this.machinePlayerView = new MachinePlayerView(this.logic);
    }

    @Test
    public void testGivenNewCoordinateViewWhenReadCoordinateThenIsCorrect() {
        int[] coordinate = this.machinePlayerView.readCoordinateToPut();
        assertNotNull(coordinate);
    }

    @Test
    public void testGivenNewCoordinateViewWhenReadCoordinateThenIsCorrec() {
        int[] coordinate1 = this.machinePlayerView.readCoordinateToPut();
        this.logic.putTokenPlayerFromTurn(coordinate1[0], coordinate1[1]);
        int[] coordinate2 = this.machinePlayerView.readCoordinateToPut();
        this.logic.putTokenPlayerFromTurn(coordinate2[0], coordinate2[1]);
        int[][] coordinates = this.machinePlayerView.readCoordinatesToMove();
        assertNotNull(coordinates[0]);
        assertNotNull(coordinates[1]);
    }
    
}