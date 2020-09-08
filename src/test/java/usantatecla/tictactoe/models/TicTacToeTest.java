package usantatecla.tictactoe.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TicTacToeTest {

    private TicTacToe tictactoe;

    private Game game;

    private Coordinate coordinate00;
    private Coordinate coordinate01;

    public TicTacToeTest() {
        this.game = new Game();
        this.tictactoe = new TicTacToe(this.game);
        this.tictactoe.createPlayers(0);
        this.coordinate00 = new Coordinate(0, 0);
        this.coordinate01 = new Coordinate(0, 1);
        this.tictactoe.registry();
    }

    @Test
    public void testGivenNewPlayControllerWhenCheckUndoableWithoutDoingAnyMovementThenIsFalse() {
        assertFalse(this.tictactoe.undoable());
    }
    
    @Test
    public void testGivenNewPlayControllerWhenCheckUndoableDoingTwoMovementsThenIsTrue() {
        this.tictactoe.registry();
        assertTrue(this.tictactoe.undoable());
    }

    @Test
    public void testGivenNewPlayControllerWhenCheckUndoableDoingOneMovementsAndUndoThenIsFalse() {
        this.tictactoe.registry();
        assertTrue(this.tictactoe.undoable());
        this.tictactoe.undo();
        assertFalse(this.tictactoe.undoable());
    }

    @Test
    public void testGivenNewPlayControllerWhenCheckRedoableDoingUndoThenIsTrue() {
        this.game.putTokenPlayerFromTurn(coordinate00);
        this.tictactoe.registry();
        this.game.putTokenPlayerFromTurn(coordinate01);
        this.tictactoe.registry();
        this.tictactoe.undo();
        assertTrue(this.tictactoe.redoable());
    }

    @Test
    public void testGivenNewPlayControllerWhenCheckRedoableDoingUndoAndRedoThenIsFalse() {
        this.game.putTokenPlayerFromTurn(coordinate00);
        this.tictactoe.registry();
        this.game.putTokenPlayerFromTurn(coordinate01);
        this.tictactoe.registry();
        this.tictactoe.undo();
        assertTrue(this.tictactoe.redoable());
        this.tictactoe.redo();
        assertFalse(this.tictactoe.redoable());
    }

    @Test
    public void testGivenNewPlayControllerWhenUndoMovementThenTheLastTokenPutIsEmpty() {
        this.game.putTokenPlayerFromTurn(coordinate00);
        this.tictactoe.registry();
        this.game.putTokenPlayerFromTurn(coordinate01);
        this.tictactoe.registry();
        this.tictactoe.undo();
        assertTrue(this.game.isEmptyToken(coordinate01));
    }

    @Test
    public void testGivenNewPlayControllerWhenUndoAndRedoMovementThenTheLastTokenPutIsOcuppiedAgain() {
        this.game.putTokenPlayerFromTurn(coordinate00);
        this.tictactoe.registry();
        this.game.putTokenPlayerFromTurn(coordinate01);
        this.tictactoe.registry();
        this.tictactoe.undo();
        assertTrue(this.game.isEmptyToken(coordinate01));
        this.tictactoe.redo();
        assertFalse(this.game.isEmptyToken(coordinate01));
    }
    
}
