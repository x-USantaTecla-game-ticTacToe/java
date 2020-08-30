package usantatecla.tictactoe.controllers.implementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.models.SessionImplementation;

public class PlayControllerImplementationTest {
    
    private PlayControllerImplementation playControllerImplementation;

    private Session session;

    Coordinate coordinate00;
    Coordinate coordinate11;
    Coordinate coordinate01;

    public PlayControllerImplementationTest() {
        this.session = new SessionImplementation();
        ((SessionImplementation) this.session).createPlayers(0);
        this.playControllerImplementation = new PlayControllerImplementation(this.session);
        this.coordinate00 = new Coordinate(0, 0);
        this.coordinate11 = new Coordinate(1, 1);
        this.coordinate01 = new Coordinate(0, 1);
    }

    @Test
    public void testGivenNewPlayControllerWhenACoordinateRow0Column0ThenIsValid() {
        assertTrue(this.playControllerImplementation.isCoordinateValid(this.coordinate00));
    }

    @Test
    public void testGivenNewPlayControllerWhenACoordinateRow2Column2ThenIsValid() {
        assertTrue(this.playControllerImplementation.isCoordinateValid(new Coordinate(2, 2)));
    }

    @Test
    public void testGivenNewPlayControllerWhenACoordinateRow3Column3ThenIsNotValid() {
        assertFalse(this.playControllerImplementation.isCoordinateValid(new Coordinate(3, 3)));
    }

    @Test
    public void testGivenNewPlayControllerWhenACoordinateRowNegativeColumnNegativeThenIsNotValid() {
        assertFalse(this.playControllerImplementation.isCoordinateValid(new Coordinate(-1, -1)));
    }

    @Test
    public void testGivenNewPlayControllerWhenGenerateRandomCoordinateThenIsNotNull() {
        assertNotNull(this.playControllerImplementation.generateRandomCoordinate());
    }

    @Test
    public void testGivenNewPlayControllerWhenPutNewTokenThenGetTokenCharIsValid() {
        this.playControllerImplementation.putTokenPlayerFromTurn(this.coordinate00);
        assertEquals('X', this.playControllerImplementation.getTokenChar(this.coordinate00));
    }

    @Test
    public void testGivenNewPlayControllerWhenPutNewTokenChangeTurnAndPutAnotherTokenThenGetTokenCharIsValid() {
        this.playControllerImplementation.putTokenPlayerFromTurn(this.coordinate00);
        assertEquals('X', this.playControllerImplementation.getTokenChar(this.coordinate00));
        this.playControllerImplementation.putTokenPlayerFromTurn(this.coordinate11);
        assertEquals('O', this.playControllerImplementation.getTokenChar(this.coordinate11));
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenPutNewTokenOnOccupiedSpaceThenAssertionError() {
        this.playControllerImplementation.putTokenPlayerFromTurn(this.coordinate00);
        assertEquals('X', this.playControllerImplementation.getTokenChar(this.coordinate00));
        this.playControllerImplementation.putTokenPlayerFromTurn(this.coordinate11);
        assertEquals('O', this.playControllerImplementation.getTokenChar(this.coordinate11));
        this.playControllerImplementation.putTokenPlayerFromTurn(new Coordinate(1, 1));
    }

    @Test
    public void testGivenNewPlayControllerWhenMoveATokenGetTokenCharTargetAndCheckEmptyTokenOriginThenMovedIsCorrect() {
        this.playControllerImplementation.putTokenPlayerFromTurn(this.coordinate00);
        assertEquals('X', this.playControllerImplementation.getTokenChar(this.coordinate00));
        this.playControllerImplementation.putTokenPlayerFromTurn(this.coordinate11);
        assertEquals('O', this.playControllerImplementation.getTokenChar(this.coordinate11));
        Coordinate[] coordinates = new Coordinate[2];
        coordinates[0] = this.coordinate00;
        coordinates[1] = this.coordinate01;
        this.playControllerImplementation.moveTokenPlayerFromTurn(coordinates);
        assertEquals('X', this.playControllerImplementation.getTokenChar(this.coordinate01));
        assertTrue(this.playControllerImplementation.isEmptyToken(this.coordinate00));
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenMoveATokenWithOriginEmptyThenAssertionError() {
        this.playControllerImplementation.putTokenPlayerFromTurn(this.coordinate00);
        assertEquals('X', this.playControllerImplementation.getTokenChar(this.coordinate00));
        this.playControllerImplementation.putTokenPlayerFromTurn(this.coordinate11);
        assertEquals('O', this.playControllerImplementation.getTokenChar(this.coordinate11));
        Coordinate[] coordinates = new Coordinate[2];
        coordinates[0] = new Coordinate(1, 0);
        coordinates[1] = this.coordinate01;
        this.playControllerImplementation.moveTokenPlayerFromTurn(coordinates);
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenMoveATokenWithTargetOccupiedThenAssertionError() {
        this.playControllerImplementation.putTokenPlayerFromTurn(this.coordinate00);
        assertEquals('X', this.playControllerImplementation.getTokenChar(this.coordinate00));
        this.playControllerImplementation.putTokenPlayerFromTurn(this.coordinate11);
        assertEquals('O', this.playControllerImplementation.getTokenChar(this.coordinate11));
        Coordinate[] coordinates = new Coordinate[2];
        coordinates[0] = this.coordinate00;
        coordinates[1] = this.coordinate11;
        this.playControllerImplementation.moveTokenPlayerFromTurn(coordinates);
    }

    @Test
    public void testGivenNewPlayControllerWhenGetCoordinateDimensionThenIsValid() {
        assertEquals(Coordinate.DIMENSION, this.playControllerImplementation.getCoordinateDimension());
    }

    @Test
    public void testGivenNewPlayControllerWhenPutTokenThenIsNotEmptyToken() {
        this.playControllerImplementation.putTokenPlayerFromTurn(this.coordinate00);
        assertFalse(this.playControllerImplementation.isEmptyToken(this.coordinate00));
    }

    @Test
    public void testGivenNewPlayControllerWhenNotPutAnyTokenThenIsEmptyToken() {
        assertTrue(this.playControllerImplementation.isEmptyToken(this.coordinate00));
    }

    @Test
    public void testGivenNewPlayControllerWhenCheckUndoableWithoutDoingAnyMovementThenIsFalse() {
        assertFalse(this.playControllerImplementation.undoable());
    }
    
    @Test
    public void testGivenNewPlayControllerWhenCheckUndoableDoingTwoMovementsThenIsTrue() {
        this.playControllerImplementation.putTokenPlayerFromTurn(this.coordinate00);
        this.playControllerImplementation.putTokenPlayerFromTurn(this.coordinate01);
        assertTrue(this.playControllerImplementation.undoable());
    }

    @Test
    public void testGivenNewPlayControllerWhenCheckUndoableDoingOneMovementAndUndoThenIsFalse() {
        this.playControllerImplementation.putTokenPlayerFromTurn(this.coordinate00);
        assertTrue(this.playControllerImplementation.undoable());
        this.playControllerImplementation.undo();
        assertFalse(this.playControllerImplementation.undoable());
    }

    @Test
    public void testGivenNewPlayControllerWhenCheckRedoableDoingUndoThenIsTrue() {
        this.playControllerImplementation.putTokenPlayerFromTurn(this.coordinate00);
        this.playControllerImplementation.putTokenPlayerFromTurn(this.coordinate01);
        this.playControllerImplementation.undo();
        assertTrue(this.playControllerImplementation.redoable());
    }

    @Test
    public void testGivenNewPlayControllerWhenCheckRedoableDoingUndoAndRedoThenIsFalse() {
        this.playControllerImplementation.putTokenPlayerFromTurn(this.coordinate00);
        this.playControllerImplementation.putTokenPlayerFromTurn(this.coordinate01);
        this.playControllerImplementation.undo();
        assertTrue(this.playControllerImplementation.redoable());
        this.playControllerImplementation.redo();
        assertFalse(this.playControllerImplementation.redoable());
    }

    @Test
    public void testGivenNewPlayControllerWhenUndoMovementThenTheLastTokenPutIsEmpty() {
        this.playControllerImplementation.putTokenPlayerFromTurn(this.coordinate00);
        this.playControllerImplementation.putTokenPlayerFromTurn(this.coordinate01);
        this.playControllerImplementation.undo();
        assertTrue(this.playControllerImplementation.isEmptyToken(this.coordinate01));
    }

    @Test
    public void testGivenNewPlayControllerWhenUndoAndRedoMovementThenTheLastTokenPutIsOcuppiedAgain() {
        this.playControllerImplementation.putTokenPlayerFromTurn(this.coordinate00);
        this.playControllerImplementation.putTokenPlayerFromTurn(this.coordinate01);
        this.playControllerImplementation.undo();
        assertTrue(this.playControllerImplementation.isEmptyToken(this.coordinate01));
        this.playControllerImplementation.redo();
        assertFalse(this.playControllerImplementation.isEmptyToken(this.coordinate01));
    }
}