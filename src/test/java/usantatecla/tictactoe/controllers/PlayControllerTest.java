package usantatecla.tictactoe.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.State;

public class PlayControllerTest {
    
    private PlayController playController;

    private Game game;

    private Coordinate coordinate00;
    private Coordinate coordinate11;
    private Coordinate coordinate01;

    public PlayControllerTest() {
        this.game = new Game();
        this.game.createPlayers(0);
        this.playController = new PlayController(this.game, new State());
        this.coordinate00 = new Coordinate(0, 0);
        this.coordinate11 = new Coordinate(1, 1);
        this.coordinate01 = new Coordinate(0, 1);
    }

    @Test
    public void testGivenNewPlayControllerWhenACoordinateRow0Column0ThenIsValid() {
        assertTrue(this.playController.isCoordinateValid(this.coordinate00));
    }

    @Test
    public void testGivenNewPlayControllerWhenACoordinateRow2Column2ThenIsValid() {
        assertTrue(this.playController.isCoordinateValid(new Coordinate(2, 2)));
    }

    @Test
    public void testGivenNewPlayControllerWhenACoordinateRow3Column3ThenIsNotValid() {
        assertFalse(this.playController.isCoordinateValid(new Coordinate(3, 3)));
    }

    @Test
    public void testGivenNewPlayControllerWhenACoordinateRowNegativeColumnNegativeThenIsNotValid() {
        assertFalse(this.playController.isCoordinateValid(new Coordinate(-1, -1)));
    }

    @Test
    public void testGivenNewPlayControllerWhenGenerateRandomCoordinateThenIsNotNull() {
        assertNotNull(this.playController.generateRandomCoordinate());
    }

    @Test
    public void testGivenNewPlayControllerWhenPutNewTokenThenGetTokenCharIsValid() {
        this.playController.putTokenPlayerFromTurn(this.coordinate00);
        assertEquals('X', this.playController.getTokenChar(this.coordinate00));
    }

    @Test
    public void testGivenNewPlayControllerWhenPutNewTokenChangeTurnAndPutAnotherTokenThenGetTokenCharIsValid() {
        this.playController.putTokenPlayerFromTurn(this.coordinate00);
        assertEquals('X', this.playController.getTokenChar(this.coordinate00));
        this.playController.changeTurn();
        this.playController.putTokenPlayerFromTurn(this.coordinate11);
        assertEquals('O', this.playController.getTokenChar(this.coordinate11));
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenPutNewTokenOnOccupiedSpaceThenAssertionError() {
        this.playController.putTokenPlayerFromTurn(this.coordinate00);
        assertEquals('X', this.playController.getTokenChar(this.coordinate00));
        this.playController.changeTurn();
        this.playController.putTokenPlayerFromTurn(this.coordinate11);
        assertEquals('O', this.playController.getTokenChar(this.coordinate11));
        this.playController.changeTurn();
        this.playController.putTokenPlayerFromTurn(this.coordinate11);
    }

    @Test
    public void testGivenNewPlayControllerWhenMoveATokenGetTokenCharTargetAndCheckEmptyTokenOriginThenMovedIsCorrect() {
        this.playController.putTokenPlayerFromTurn(this.coordinate00);
        assertEquals('X', this.playController.getTokenChar(this.coordinate00));
        this.playController.changeTurn();
        this.playController.putTokenPlayerFromTurn(this.coordinate11);
        assertEquals('O', this.playController.getTokenChar(this.coordinate11));
        this.playController.changeTurn();
        this.playController.moveTokenPlayerFromTurn(this.coordinate00, this.coordinate01);
        assertEquals('X', this.playController.getTokenChar(this.coordinate01));
        assertTrue(this.playController.isEmptyToken(this.coordinate00));
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenMoveATokenWithOriginEmptyThenAssertionError() {
        this.playController.putTokenPlayerFromTurn(this.coordinate00);
        assertEquals('X', this.playController.getTokenChar(this.coordinate00));
        this.playController.changeTurn();
        this.playController.putTokenPlayerFromTurn(this.coordinate11);
        assertEquals('O', this.playController.getTokenChar(this.coordinate11));
        this.playController.changeTurn();
        this.playController.moveTokenPlayerFromTurn(new Coordinate(1, 0), this.coordinate01);
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenMoveATokenWithTargetOccupiedThenAssertionError() {
        this.playController.putTokenPlayerFromTurn(this.coordinate00);
        assertEquals('X', this.playController.getTokenChar(this.coordinate00));
        this.playController.changeTurn();
        this.playController.putTokenPlayerFromTurn(this.coordinate11);
        assertEquals('O', this.playController.getTokenChar(this.coordinate11));
        this.playController.changeTurn();
        this.playController.moveTokenPlayerFromTurn(this.coordinate00, this.coordinate11);
    }

    @Test
    public void testGivenNewPlayControllerWhenGetCoordinateDimensionThenIsValid() {
        assertEquals(Coordinate.DIMENSION, this.playController.getCoordinateDimension());
    }

    @Test
    public void testGivenNewPlayControllerWhenPutTokenThenIsNotEmptyToken() {
        this.playController.putTokenPlayerFromTurn(this.coordinate00);
        assertFalse(this.playController.isEmptyToken(this.coordinate00));
    }

    @Test
    public void testGivenNewPlayControllerWhenNotPutAnyTokenThenIsEmptyToken() {
        assertTrue(this.playController.isEmptyToken(this.coordinate00));
    }
}