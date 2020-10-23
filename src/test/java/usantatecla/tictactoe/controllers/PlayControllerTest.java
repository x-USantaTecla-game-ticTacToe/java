package usantatecla.tictactoe.controllers;

// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertFalse;
// import static org.junit.Assert.assertNotNull;
// import static org.junit.Assert.assertTrue;

// import org.junit.Test;

// import usantatecla.tictactoe.models.Coordinate;
// import usantatecla.tictactoe.models.Session;

public class PlayControllerTest {
    
    // private PlayController playController;

    // private Session session;

    // private Coordinate coordinate00;
    // private Coordinate coordinate11;
    // private Coordinate coordinate01;

    // public PlayControllerTest() {
    //     this.session = new Session();
    //     this.session.createPlayers(0);
    //     this.playController = new PlayController(this.session);
    //     this.coordinate00 = new Coordinate(0, 0);
    //     this.coordinate11 = new Coordinate(1, 1);
    //     this.coordinate01 = new Coordinate(0, 1);
    // }

    // @Test
    // public void testGivenNewPlayControllerWhenACoordinateRow0Column0ThenIsValid() {
    //     assertTrue(this.playController.isCoordinateValid(this.coordinate00));
    // }

    // @Test
    // public void testGivenNewPlayControllerWhenACoordinateRow2Column2ThenIsValid() {
    //     assertTrue(this.playController.isCoordinateValid(new Coordinate(2, 2)));
    // }

    // @Test
    // public void testGivenNewPlayControllerWhenACoordinateRow3Column3ThenIsNotValid() {
    //     assertFalse(this.playController.isCoordinateValid(new Coordinate(3, 3)));
    // }

    // @Test
    // public void testGivenNewPlayControllerWhenACoordinateRowNegativeColumnNegativeThenIsNotValid() {
    //     assertFalse(this.playController.isCoordinateValid(new Coordinate(-1, -1)));
    // }

    // @Test
    // public void testGivenNewPlayControllerWhenGenerateRandomCoordinateThenIsNotNull() {
    //     assertNotNull(this.playController.generateRandomCoordinate());
    // }

    // @Test
    // public void testGivenNewPlayControllerWhenPutNewTokenThenGetTokenCharIsValid() {
    //     this.playController.putTokenPlayerFromTurn(this.coordinate00);
    //     assertEquals('X', this.playController.getTokenChar(this.coordinate00));
    // }

    // @Test
    // public void testGivenNewPlayControllerWhenPutNewTokenChangeTurnAndPutAnotherTokenThenGetTokenCharIsValid() {
    //     this.playController.putTokenPlayerFromTurn(this.coordinate00);
    //     assertEquals('X', this.playController.getTokenChar(this.coordinate00));
    //     this.playController.putTokenPlayerFromTurn(this.coordinate11);
    //     assertEquals('O', this.playController.getTokenChar(this.coordinate11));
    // }

    // @Test(expected = AssertionError.class)
    // public void testGivenNewPlayControllerWhenPutNewTokenOnOccupiedSpaceThenAssertionError() {
    //     this.playController.putTokenPlayerFromTurn(this.coordinate00);
    //     assertEquals('X', this.playController.getTokenChar(this.coordinate00));
    //     this.playController.putTokenPlayerFromTurn(this.coordinate11);
    //     assertEquals('O', this.playController.getTokenChar(this.coordinate11));
    //     this.playController.putTokenPlayerFromTurn(this.coordinate11);
    // }

    // @Test
    // public void testGivenNewPlayControllerWhenMoveATokenGetTokenCharTargetAndCheckEmptyTokenOriginThenMovedIsCorrect() {
    //     this.playController.putTokenPlayerFromTurn(this.coordinate00);
    //     assertEquals('X', this.playController.getTokenChar(this.coordinate00));
    //     this.playController.putTokenPlayerFromTurn(this.coordinate11);
    //     assertEquals('O', this.playController.getTokenChar(this.coordinate11));
    //     this.playController.moveTokenPlayerFromTurn(this.coordinate00, this.coordinate01);
    //     assertEquals('X', this.playController.getTokenChar(this.coordinate01));
    //     assertTrue(this.playController.isEmptyToken(this.coordinate00));
    // }

    // @Test(expected = AssertionError.class)
    // public void testGivenNewPlayControllerWhenMoveATokenWithOriginEmptyThenAssertionError() {
    //     this.playController.putTokenPlayerFromTurn(this.coordinate00);
    //     assertEquals('X', this.playController.getTokenChar(this.coordinate00));
    //     this.playController.putTokenPlayerFromTurn(this.coordinate11);
    //     assertEquals('O', this.playController.getTokenChar(this.coordinate11));
    //     this.playController.moveTokenPlayerFromTurn(new Coordinate(1, 0), this.coordinate01);
    // }

    // @Test(expected = AssertionError.class)
    // public void testGivenNewPlayControllerWhenMoveATokenWithTargetOccupiedThenAssertionError() {
    //     this.playController.putTokenPlayerFromTurn(this.coordinate00);
    //     assertEquals('X', this.playController.getTokenChar(this.coordinate00));
    //     this.playController.putTokenPlayerFromTurn(this.coordinate11);
    //     assertEquals('O', this.playController.getTokenChar(this.coordinate11));
    //     this.playController.moveTokenPlayerFromTurn(this.coordinate00, this.coordinate11);
    // }

    // @Test
    // public void testGivenNewPlayControllerWhenGetCoordinateDimensionThenIsValid() {
    //     assertEquals(Coordinate.DIMENSION, this.playController.getCoordinateDimension());
    // }

    // @Test
    // public void testGivenNewPlayControllerWhenPutTokenThenIsNotEmptyToken() {
    //     this.playController.putTokenPlayerFromTurn(this.coordinate00);
    //     assertFalse(this.playController.isEmptyToken(this.coordinate00));
    // }

    // @Test
    // public void testGivenNewPlayControllerWhenNotPutAnyTokenThenIsEmptyToken() {
    //     assertTrue(this.playController.isEmptyToken(this.coordinate00));
    // }

    // @Test
    // public void testGivenNewPlayControllerWhenCheckUndoableWithoutDoingAnyMovementThenIsFalse() {
    //     assertFalse(this.playController.undoable());
    // }
    
    // @Test
    // public void testGivenNewPlayControllerWhenCheckUndoableDoingTwoMovementsThenIsTrue() {
    //     this.playController.putTokenPlayerFromTurn(coordinate00);
    //     this.playController.putTokenPlayerFromTurn(coordinate01);
    //     assertTrue(this.playController.undoable());
    // }

    // @Test
    // public void testGivenNewPlayControllerWhenCheckUndoableDoingOneMovementsAndUndoThenIsFalse() {
    //     this.playController.putTokenPlayerFromTurn(coordinate00);
    //     assertTrue(this.playController.undoable());
    //     this.playController.undo();
    //     assertFalse(this.playController.undoable());
    // }

    // @Test
    // public void testGivenNewPlayControllerWhenCheckRedoableDoingUndoThenIsTrue() {
    //     this.playController.putTokenPlayerFromTurn(coordinate00);
    //     this.playController.putTokenPlayerFromTurn(coordinate01);
    //     this.playController.undo();
    //     assertTrue(this.playController.redoable());
    // }

    // @Test
    // public void testGivenNewPlayControllerWhenCheckRedoableDoingUndoAndRedoThenIsFalse() {
    //     this.playController.putTokenPlayerFromTurn(coordinate00);
    //     this.playController.putTokenPlayerFromTurn(coordinate01);
    //     this.playController.undo();
    //     assertTrue(this.playController.redoable());
    //     this.playController.redo();
    //     assertFalse(this.playController.redoable());
    // }

    // @Test
    // public void testGivenNewPlayControllerWhenUndoMovementThenTheLastTokenPutIsEmpty() {
    //     this.playController.putTokenPlayerFromTurn(coordinate00);
    //     this.playController.putTokenPlayerFromTurn(coordinate01);
    //     this.playController.undo();
    //     assertTrue(this.playController.isEmptyToken(coordinate01));
    // }

    // @Test
    // public void testGivenNewPlayControllerWhenUndoAndRedoMovementThenTheLastTokenPutIsOcuppiedAgain() {
    //     this.playController.putTokenPlayerFromTurn(coordinate00);
    //     this.playController.putTokenPlayerFromTurn(coordinate01);
    //     this.playController.undo();
    //     assertTrue(this.playController.isEmptyToken(coordinate01));
    //     this.playController.redo();
    //     assertFalse(this.playController.isEmptyToken(coordinate01));
    // }
}