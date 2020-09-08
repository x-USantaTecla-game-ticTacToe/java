package usantatecla.tictactoe.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GameTest {

    private Game game;

    private Coordinate coordinate00;
    private Coordinate coordinate11;
    private Coordinate coordinate01;

    public GameTest() {
        this.game = new Game();
        this.game.createPlayers(0);
        this.coordinate00 = new Coordinate(0, 0);
        this.coordinate11 = new Coordinate(1, 1);
        this.coordinate01 = new Coordinate(0, 1);
    }

    @Test
    public void testGivenNewPlayControllerWhenPutNewTokenThenGetTokenCharIsValid() {
        this.game.putTokenPlayerFromTurn(this.coordinate00);
        assertEquals('X', this.game.getTokenChar(this.coordinate00));
    }

    @Test
    public void testGivenNewPlayControllerWhenPutNewTokenChangeTurnAndPutAnotherTokenThenGetTokenCharIsValid() {
        this.game.putTokenPlayerFromTurn(this.coordinate00);
        assertEquals('X', this.game.getTokenChar(this.coordinate00));
        this.game.putTokenPlayerFromTurn(this.coordinate11);
        assertEquals('O', this.game.getTokenChar(this.coordinate11));
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenPutNewTokenOnOccupiedSpaceThenAssertionError() {
        this.game.putTokenPlayerFromTurn(this.coordinate00);
        assertEquals('X', this.game.getTokenChar(this.coordinate00));
        this.game.putTokenPlayerFromTurn(this.coordinate11);
        assertEquals('O', this.game.getTokenChar(this.coordinate11));
        this.game.putTokenPlayerFromTurn(this.coordinate11);
    }

    @Test
    public void testGivenNewPlayControllerWhenMoveATokenGetTokenCharTargetAndCheckEmptyTokenOriginThenMovedIsCorrect() {
        this.game.putTokenPlayerFromTurn(this.coordinate00);
        assertEquals('X', this.game.getTokenChar(this.coordinate00));
        this.game.putTokenPlayerFromTurn(this.coordinate11);
        assertEquals('O', this.game.getTokenChar(this.coordinate11));
        Coordinate[] coordinates = new Coordinate[2];
        coordinates[0] = this.coordinate00;
        coordinates[1] = this.coordinate01;
        this.game.moveTokenPlayerFromTurn(coordinates);
        assertEquals('X', this.game.getTokenChar(this.coordinate01));
        assertTrue(this.game.isEmptyToken(this.coordinate00));
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenMoveATokenWithOriginEmptyThenAssertionError() {
        this.game.putTokenPlayerFromTurn(this.coordinate00);
        assertEquals('X', this.game.getTokenChar(this.coordinate00));
        this.game.putTokenPlayerFromTurn(this.coordinate11);
        assertEquals('O', this.game.getTokenChar(this.coordinate11));
        Coordinate[] coordinates = new Coordinate[2];
        coordinates[0] = new Coordinate(1, 0);
        coordinates[1] = this.coordinate01;
        this.game.moveTokenPlayerFromTurn(coordinates);
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenMoveATokenWithTargetOccupiedThenAssertionError() {
        this.game.putTokenPlayerFromTurn(this.coordinate00);
        assertEquals('X', this.game.getTokenChar(this.coordinate00));
        this.game.putTokenPlayerFromTurn(this.coordinate11);
        assertEquals('O', this.game.getTokenChar(this.coordinate11));
        Coordinate[] coordinates = new Coordinate[2];
        coordinates[0] = this.coordinate00;
        coordinates[1] = this.coordinate11;
        this.game.moveTokenPlayerFromTurn(coordinates);
    }

    @Test
    public void testGivenNewPlayControllerWhenGetCoordinateDimensionThenIsValid() {
        assertEquals(Coordinate.DIMENSION, this.game.getCoordinateDimension());
    }

    @Test
    public void testGivenNewPlayControllerWhenPutTokenThenIsNotEmptyToken() {
        this.game.putTokenPlayerFromTurn(this.coordinate00);
        assertFalse(this.game.isEmptyToken(this.coordinate00));
    }

    @Test
    public void testGivenNewPlayControllerWhenNotPutAnyTokenThenIsEmptyToken() {
        assertTrue(this.game.isEmptyToken(this.coordinate00));
    }

}