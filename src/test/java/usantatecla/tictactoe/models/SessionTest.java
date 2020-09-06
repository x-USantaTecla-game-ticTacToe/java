package usantatecla.tictactoe.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SessionTest {

    private Session session;

    private Coordinate coordinate00;
    private Coordinate coordinate11;
    private Coordinate coordinate01;

    public SessionTest() {
        this.session = new Session();
        this.session.createPlayers(0);
        this.coordinate00 = new Coordinate(0, 0);
        this.coordinate11 = new Coordinate(1, 1);
        this.coordinate01 = new Coordinate(0, 1);
    }

    @Test
    public void testGivenNewPlayControllerWhenPutNewTokenThenGetTokenCharIsValid() {
        this.session.putTokenPlayerFromTurn(this.coordinate00);
        assertEquals('X', this.session.getTokenChar(this.coordinate00));
    }

    @Test
    public void testGivenNewPlayControllerWhenPutNewTokenChangeTurnAndPutAnotherTokenThenGetTokenCharIsValid() {
        this.session.putTokenPlayerFromTurn(this.coordinate00);
        assertEquals('X', this.session.getTokenChar(this.coordinate00));
        this.session.putTokenPlayerFromTurn(this.coordinate11);
        assertEquals('O', this.session.getTokenChar(this.coordinate11));
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenPutNewTokenOnOccupiedSpaceThenAssertionError() {
        this.session.putTokenPlayerFromTurn(this.coordinate00);
        assertEquals('X', this.session.getTokenChar(this.coordinate00));
        this.session.putTokenPlayerFromTurn(this.coordinate11);
        assertEquals('O', this.session.getTokenChar(this.coordinate11));
        this.session.putTokenPlayerFromTurn(this.coordinate11);
    }

    @Test
    public void testGivenNewPlayControllerWhenMoveATokenGetTokenCharTargetAndCheckEmptyTokenOriginThenMovedIsCorrect() {
        this.session.putTokenPlayerFromTurn(this.coordinate00);
        assertEquals('X', this.session.getTokenChar(this.coordinate00));
        this.session.putTokenPlayerFromTurn(this.coordinate11);
        assertEquals('O', this.session.getTokenChar(this.coordinate11));
        Coordinate[] coordinates = new Coordinate[2];
        coordinates[0] = this.coordinate00;
        coordinates[1] = this.coordinate01;
        this.session.moveTokenPlayerFromTurn(coordinates);
        assertEquals('X', this.session.getTokenChar(this.coordinate01));
        assertTrue(this.session.isEmptyToken(this.coordinate00));
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenMoveATokenWithOriginEmptyThenAssertionError() {
        this.session.putTokenPlayerFromTurn(this.coordinate00);
        assertEquals('X', this.session.getTokenChar(this.coordinate00));
        this.session.putTokenPlayerFromTurn(this.coordinate11);
        assertEquals('O', this.session.getTokenChar(this.coordinate11));
        Coordinate[] coordinates = new Coordinate[2];
        coordinates[0] = new Coordinate(1, 0);
        coordinates[1] = this.coordinate01;
        this.session.moveTokenPlayerFromTurn(coordinates);
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenMoveATokenWithTargetOccupiedThenAssertionError() {
        this.session.putTokenPlayerFromTurn(this.coordinate00);
        assertEquals('X', this.session.getTokenChar(this.coordinate00));
        this.session.putTokenPlayerFromTurn(this.coordinate11);
        assertEquals('O', this.session.getTokenChar(this.coordinate11));
        Coordinate[] coordinates = new Coordinate[2];
        coordinates[0] = this.coordinate00;
        coordinates[1] = this.coordinate11;
        this.session.moveTokenPlayerFromTurn(coordinates);
    }

    @Test
    public void testGivenNewPlayControllerWhenGetCoordinateDimensionThenIsValid() {
        assertEquals(Coordinate.DIMENSION, this.session.getCoordinateDimension());
    }

    @Test
    public void testGivenNewPlayControllerWhenPutTokenThenIsNotEmptyToken() {
        this.session.putTokenPlayerFromTurn(this.coordinate00);
        assertFalse(this.session.isEmptyToken(this.coordinate00));
    }

    @Test
    public void testGivenNewPlayControllerWhenNotPutAnyTokenThenIsEmptyToken() {
        assertTrue(this.session.isEmptyToken(this.coordinate00));
    }

    @Test
    public void testGivenNewPlayControllerWhenCheckUndoableWithoutDoingAnyMovementThenIsFalse() {
        assertFalse(this.session.undoable());
    }
    
    @Test
    public void testGivenNewPlayControllerWhenCheckUndoableDoingTwoMovementsThenIsTrue() {
        this.session.putTokenPlayerFromTurn(coordinate00);
        this.session.putTokenPlayerFromTurn(coordinate01);
        assertTrue(this.session.undoable());
    }

    @Test
    public void testGivenNewPlayControllerWhenCheckUndoableDoingOneMovementsAndUndoThenIsFalse() {
        this.session.putTokenPlayerFromTurn(coordinate00);
        assertTrue(this.session.undoable());
        this.session.undo();
        assertFalse(this.session.undoable());
    }

    @Test
    public void testGivenNewPlayControllerWhenCheckRedoableDoingUndoThenIsTrue() {
        this.session.putTokenPlayerFromTurn(coordinate00);
        this.session.putTokenPlayerFromTurn(coordinate01);
        this.session.undo();
        assertTrue(this.session.redoable());
    }

    @Test
    public void testGivenNewPlayControllerWhenCheckRedoableDoingUndoAndRedoThenIsFalse() {
        this.session.putTokenPlayerFromTurn(coordinate00);
        this.session.putTokenPlayerFromTurn(coordinate01);
        this.session.undo();
        assertTrue(this.session.redoable());
        this.session.redo();
        assertFalse(this.session.redoable());
    }

    @Test
    public void testGivenNewPlayControllerWhenUndoMovementThenTheLastTokenPutIsEmpty() {
        this.session.putTokenPlayerFromTurn(coordinate00);
        this.session.putTokenPlayerFromTurn(coordinate01);
        this.session.undo();
        assertTrue(this.session.isEmptyToken(coordinate01));
    }

    @Test
    public void testGivenNewPlayControllerWhenUndoAndRedoMovementThenTheLastTokenPutIsOcuppiedAgain() {
        this.session.putTokenPlayerFromTurn(coordinate00);
        this.session.putTokenPlayerFromTurn(coordinate01);
        this.session.undo();
        assertTrue(this.session.isEmptyToken(coordinate01));
        this.session.redo();
        assertFalse(this.session.isEmptyToken(coordinate01));
    }
}