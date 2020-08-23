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

    public PlayControllerImplementationTest() {
        this.session = new SessionImplementation();
        ((SessionImplementation) this.session).createPlayers(0);
        this.playControllerImplementation = new PlayControllerImplementation(this.session);
    }

    @Test
    public void testGivenNewPlayControllerWhenACoordinateRow0Column0ThenIsValid() {
        assertTrue(this.playControllerImplementation.isCoordinateValid(0, 0));
    }

    @Test
    public void testGivenNewPlayControllerWhenACoordinateRow2Column2ThenIsValid() {
        assertTrue(this.playControllerImplementation.isCoordinateValid(2, 2));
    }

    @Test
    public void testGivenNewPlayControllerWhenACoordinateRow3Column3ThenIsNotValid() {
        assertFalse(this.playControllerImplementation.isCoordinateValid(3, 3));
    }

    @Test
    public void testGivenNewPlayControllerWhenACoordinateRowNegativeColumnNegativeThenIsNotValid() {
        assertFalse(this.playControllerImplementation.isCoordinateValid(-1, -1));
    }

    @Test
    public void testGivenNewPlayControllerWhenGenerateRandomCoordinateThenIsNotNull() {
        assertNotNull(this.playControllerImplementation.generateRandomCoordinate());
    }

    @Test
    public void testGivenNewPlayControllerWhenPutNewTokenThenGetTokenCharIsValid() {
        this.playControllerImplementation.putTokenPlayerFromTurn(0, 0);
        assertEquals('X', this.playControllerImplementation.getTokenChar(0, 0));
    }

    @Test
    public void testGivenNewPlayControllerWhenPutNewTokenChangeTurnAndPutAnotherTokenThenGetTokenCharIsValid() {
        this.playControllerImplementation.putTokenPlayerFromTurn(0, 0);
        assertEquals('X', this.playControllerImplementation.getTokenChar(0, 0));
        this.playControllerImplementation.changeTurn();
        this.playControllerImplementation.putTokenPlayerFromTurn(1, 1);
        assertEquals('O', this.playControllerImplementation.getTokenChar(1, 1));
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenPutNewTokenOnOccupiedSpaceThenAssertionError() {
        this.playControllerImplementation.putTokenPlayerFromTurn(0, 0);
        assertEquals('X', this.playControllerImplementation.getTokenChar(0, 0));
        this.playControllerImplementation.changeTurn();
        this.playControllerImplementation.putTokenPlayerFromTurn(1, 1);
        assertEquals('O', this.playControllerImplementation.getTokenChar(1, 1));
        this.playControllerImplementation.changeTurn();
        this.playControllerImplementation.putTokenPlayerFromTurn(1, 1);
    }

    @Test
    public void testGivenNewPlayControllerWhenMoveATokenGetTokenCharTargetAndCheckEmptyTokenOriginThenMovedIsCorrect() {
        this.playControllerImplementation.putTokenPlayerFromTurn(0, 0);
        assertEquals('X', this.playControllerImplementation.getTokenChar(0, 0));
        this.playControllerImplementation.changeTurn();
        this.playControllerImplementation.putTokenPlayerFromTurn(1, 1);
        assertEquals('O', this.playControllerImplementation.getTokenChar(1, 1));
        this.playControllerImplementation.changeTurn();
        this.playControllerImplementation.moveTokenPlayerFromTurn(0, 0, 0, 1);
        assertEquals('X', this.playControllerImplementation.getTokenChar(0, 1));
        assertTrue(this.playControllerImplementation.isEmptyToken(0, 0));
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenMoveATokenWithOriginEmptyThenAssertionError() {
        this.playControllerImplementation.putTokenPlayerFromTurn(0, 0);
        assertEquals('X', this.playControllerImplementation.getTokenChar(0, 0));
        this.playControllerImplementation.changeTurn();
        this.playControllerImplementation.putTokenPlayerFromTurn(1, 1);
        assertEquals('O', this.playControllerImplementation.getTokenChar(1, 1));
        this.playControllerImplementation.changeTurn();
        this.playControllerImplementation.moveTokenPlayerFromTurn(1, 0, 0, 1);
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenMoveATokenWithTargetOccupiedThenAssertionError() {
        this.playControllerImplementation.putTokenPlayerFromTurn(0, 0);
        assertEquals('X', this.playControllerImplementation.getTokenChar(0, 0));
        this.playControllerImplementation.changeTurn();
        this.playControllerImplementation.putTokenPlayerFromTurn(1, 1);
        assertEquals('O', this.playControllerImplementation.getTokenChar(1, 1));
        this.playControllerImplementation.changeTurn();
        this.playControllerImplementation.moveTokenPlayerFromTurn(0, 0, 1, 1);
    }

    @Test
    public void testGivenNewPlayControllerWhenGetCoordinateDimensionThenIsValid() {
        assertEquals(Coordinate.DIMENSION, this.playControllerImplementation.getCoordinateDimension());
    }

    @Test
    public void testGivenNewPlayControllerWhenPutTokenThenIsNotEmptyToken() {
        this.playControllerImplementation.putTokenPlayerFromTurn(0, 0);
        assertFalse(this.playControllerImplementation.isEmptyToken(0, 0));
    }

    @Test
    public void testGivenNewPlayControllerWhenNotPutAnyTokenThenIsEmptyToken() {
        assertTrue(this.playControllerImplementation.isEmptyToken(0, 0));
    }

    @Test
    public void testGivenNewPlayControllerWhenCheckUndoableWithoutDoingAnyMovementThenIsFalse() {
        assertFalse(this.playControllerImplementation.undoable());
    }
    
    @Test
    public void testGivenNewPlayControllerWhenCheckUndoableDoingTwoMovementsThenIsTrue() {
        this.playControllerImplementation.putTokenPlayerFromTurn(0, 0);
        this.playControllerImplementation.changeTurn();
        this.playControllerImplementation.putTokenPlayerFromTurn(0, 1);
        this.playControllerImplementation.changeTurn();
        assertTrue(this.playControllerImplementation.undoable());
    }

    @Test
    public void testGivenNewPlayControllerWhenCheckUndoableDoingTwoMovementsAndUndoThenIsFalse() {
        this.playControllerImplementation.putTokenPlayerFromTurn(0, 0);
        this.playControllerImplementation.changeTurn();
        this.playControllerImplementation.putTokenPlayerFromTurn(0, 1);
        this.playControllerImplementation.changeTurn();
        assertTrue(this.playControllerImplementation.undoable());
        this.playControllerImplementation.undo();
        assertFalse(this.playControllerImplementation.undoable());
    }

    @Test
    public void testGivenNewPlayControllerWhenCheckRedoableDoingUndoThenIsTrue() {
        this.playControllerImplementation.putTokenPlayerFromTurn(0, 0);
        this.playControllerImplementation.changeTurn();
        this.playControllerImplementation.putTokenPlayerFromTurn(0, 1);
        this.playControllerImplementation.changeTurn();
        this.playControllerImplementation.undo();
        assertTrue(this.playControllerImplementation.redoable());
    }

    @Test
    public void testGivenNewPlayControllerWhenCheckRedoableDoingUndoAndRedoThenIsFalse() {
        this.playControllerImplementation.putTokenPlayerFromTurn(0, 0);
        this.playControllerImplementation.changeTurn();
        this.playControllerImplementation.putTokenPlayerFromTurn(0, 1);
        this.playControllerImplementation.changeTurn();
        this.playControllerImplementation.undo();
        assertTrue(this.playControllerImplementation.redoable());
        this.playControllerImplementation.redo();
        assertFalse(this.playControllerImplementation.redoable());
    }

    @Test
    public void testGivenNewPlayControllerWhenUndoMovementThenTheLastTokenPutIsEmpty() {
        this.playControllerImplementation.putTokenPlayerFromTurn(0, 0);
        this.playControllerImplementation.changeTurn();
        this.playControllerImplementation.putTokenPlayerFromTurn(0, 1);
        this.playControllerImplementation.changeTurn();
        this.playControllerImplementation.undo();
        assertTrue(this.playControllerImplementation.isEmptyToken(0, 1));
    }

    @Test
    public void testGivenNewPlayControllerWhenUndoAndRedoMovementThenTheLastTokenPutIsOcuppiedAgain() {
        this.playControllerImplementation.putTokenPlayerFromTurn(0, 0);
        this.playControllerImplementation.changeTurn();
        this.playControllerImplementation.putTokenPlayerFromTurn(0, 1);
        this.playControllerImplementation.changeTurn();
        this.playControllerImplementation.undo();
        assertTrue(this.playControllerImplementation.isEmptyToken(0, 1));
        this.playControllerImplementation.redo();
        assertFalse(this.playControllerImplementation.isEmptyToken(0, 1));
    }
}