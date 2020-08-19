package usantatecla.tictactoe.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Session;

public class PlayControllerTest {
    
    private PlayController playController;

    private Session session;

    public PlayControllerTest() {
        this.session = new Session();
        this.session.createPlayers(0);
        this.playController = new PlayController(this.session);
    }

    @Test
    public void testGivenNewPlayControllerWhenACoordinateRow0Column0ThenIsValid() {
        assertTrue(this.playController.isCoordinateValid(0, 0));
    }

    @Test
    public void testGivenNewPlayControllerWhenACoordinateRow2Column2ThenIsValid() {
        assertTrue(this.playController.isCoordinateValid(2, 2));
    }

    @Test
    public void testGivenNewPlayControllerWhenACoordinateRow3Column3ThenIsNotValid() {
        assertFalse(this.playController.isCoordinateValid(3, 3));
    }

    @Test
    public void testGivenNewPlayControllerWhenACoordinateRowNegativeColumnNegativeThenIsNotValid() {
        assertFalse(this.playController.isCoordinateValid(-1, -1));
    }

    @Test
    public void testGivenNewPlayControllerWhenGenerateRandomCoordinateThenIsNotNull() {
        assertNotNull(this.playController.generateRandomCoordinate());
    }

    @Test
    public void testGivenNewPlayControllerWhenPutNewTokenThenGetTokenCharIsValid() {
        this.playController.putTokenPlayerFromTurn(0, 0);
        assertEquals('X', this.playController.getTokenChar(0, 0));
    }

    @Test
    public void testGivenNewPlayControllerWhenPutNewTokenChangeTurnAndPutAnotherTokenThenGetTokenCharIsValid() {
        this.playController.putTokenPlayerFromTurn(0, 0);
        assertEquals('X', this.playController.getTokenChar(0, 0));
        this.playController.changeTurn();
        this.playController.putTokenPlayerFromTurn(1, 1);
        assertEquals('O', this.playController.getTokenChar(1, 1));
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenPutNewTokenOnOccupiedSpaceThenAssertionError() {
        this.playController.putTokenPlayerFromTurn(0, 0);
        assertEquals('X', this.playController.getTokenChar(0, 0));
        this.playController.changeTurn();
        this.playController.putTokenPlayerFromTurn(1, 1);
        assertEquals('O', this.playController.getTokenChar(1, 1));
        this.playController.changeTurn();
        this.playController.putTokenPlayerFromTurn(1, 1);
    }

    @Test
    public void testGivenNewPlayControllerWhenMoveATokenGetTokenCharTargetAndCheckEmptyTokenOriginThenMovedIsCorrect() {
        this.playController.putTokenPlayerFromTurn(0, 0);
        assertEquals('X', this.playController.getTokenChar(0, 0));
        this.playController.changeTurn();
        this.playController.putTokenPlayerFromTurn(1, 1);
        assertEquals('O', this.playController.getTokenChar(1, 1));
        this.playController.changeTurn();
        this.playController.moveTokenPlayerFromTurn(0, 0, 0, 1);
        assertEquals('X', this.playController.getTokenChar(0, 1));
        assertTrue(this.playController.isEmptyToken(0, 0));
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenMoveATokenWithOriginEmptyThenAssertionError() {
        this.playController.putTokenPlayerFromTurn(0, 0);
        assertEquals('X', this.playController.getTokenChar(0, 0));
        this.playController.changeTurn();
        this.playController.putTokenPlayerFromTurn(1, 1);
        assertEquals('O', this.playController.getTokenChar(1, 1));
        this.playController.changeTurn();
        this.playController.moveTokenPlayerFromTurn(1, 0, 0, 1);
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenMoveATokenWithTargetOccupiedThenAssertionError() {
        this.playController.putTokenPlayerFromTurn(0, 0);
        assertEquals('X', this.playController.getTokenChar(0, 0));
        this.playController.changeTurn();
        this.playController.putTokenPlayerFromTurn(1, 1);
        assertEquals('O', this.playController.getTokenChar(1, 1));
        this.playController.changeTurn();
        this.playController.moveTokenPlayerFromTurn(0, 0, 1, 1);
    }

    @Test
    public void testGivenNewPlayControllerWhenGetCoordinateDimensionThenIsValid() {
        assertEquals(Coordinate.DIMENSION, this.playController.getCoordinateDimension());
    }

    @Test
    public void testGivenNewPlayControllerWhenPutTokenThenIsNotEmptyToken() {
        this.playController.putTokenPlayerFromTurn(0, 0);
        assertFalse(this.playController.isEmptyToken(0, 0));
    }

    @Test
    public void testGivenNewPlayControllerWhenNotPutAnyTokenThenIsEmptyToken() {
        assertTrue(this.playController.isEmptyToken(0, 0));
    }
}