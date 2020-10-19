package usantatecla.tictactoe.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Token;

public class PlayControllerTest {
    
    private PlayController playController;

    private Game game;

    private Coordinate coordinate00;
    private Coordinate coordinate11;
    private Coordinate coordinate01;

    public PlayControllerTest() {
        this.game = new Game();
        this.game.setUsers(0);
        this.playController = new PlayController(this.game);
        this.coordinate00 = new Coordinate(0, 0);
        this.coordinate11 = new Coordinate(1, 1);
        this.coordinate01 = new Coordinate(0, 1);
    }

    @Test
    public void testGivenNewPlayControllerWhenPutNewTokenThenGetTokenCharIsValid() {
        this.playController.put(this.coordinate00);
        assertEquals(Token.O, this.playController.getToken(this.coordinate00));
    }

    @Test
    public void testGivenNewPlayControllerWhenPutNewTokenChangeTurnAndPutAnotherTokenThenGetTokenCharIsValid() {
        this.playController.put(this.coordinate00);
        assertEquals(Token.O, this.playController.getToken(this.coordinate00));
        this.playController.next();
        this.playController.put(this.coordinate11);
        assertEquals(Token.X, this.playController.getToken(this.coordinate11));
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenPutNewTokenOnOccupiedSpaceThenAssertionError() {
        this.playController.put(this.coordinate00);
        assertEquals(Token.X, this.playController.getToken(this.coordinate00));
        this.playController.next();
        this.playController.put(this.coordinate11);
        assertEquals(Token.O, this.playController.getToken(this.coordinate11));
        this.playController.next();
        this.playController.put(this.coordinate11);
    }

    @Test
    public void testGivenNewPlayControllerWhenMoveATokenGetTokenCharTargetAndCheckEmptyTokenOriginThenMovedIsCorrect() {
        this.playController.put(this.coordinate00);
        assertEquals(Token.O, this.playController.getToken(this.coordinate00));
        this.playController.next();
        this.playController.put(this.coordinate11);
        assertEquals(Token.X, this.playController.getToken(this.coordinate11));
        this.playController.next();
        this.playController.move(this.coordinate00, this.coordinate01);
        assertEquals(Token.O, this.playController.getToken(this.coordinate01));
        assertEquals(Token.NULL, this.playController.getToken(this.coordinate00));
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenMoveATokenWithOriginEmptyThenAssertionError() {
        this.playController.put(this.coordinate00);
        assertEquals(Token.X, this.playController.getToken(this.coordinate00));
        this.playController.next();
        this.playController.put(this.coordinate11);
        assertEquals(Token.O, this.playController.getToken(this.coordinate11));
        this.playController.next();
        this.playController.move(new Coordinate(1, 0), this.coordinate01);
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewPlayControllerWhenMoveATokenWithTargetOccupiedThenAssertionError() {
        this.playController.put(this.coordinate00);
        assertEquals(Token.X, this.playController.getToken(this.coordinate00));
        this.playController.next();
        this.playController.put(this.coordinate11);
        assertEquals(Token.O, this.playController.getToken(this.coordinate11));
        this.playController.next();
        this.playController.move(this.coordinate00, this.coordinate11);
    }

    @Test
    public void testGivenNewPlayControllerWhenPutTokenThenIsNotEmptyToken() {
        this.playController.put(this.coordinate00);
        assertEquals(Token.O, this.playController.getToken(this.coordinate00));
    }

    @Test
    public void testGivenNewPlayControllerWhenNotPutAnyTokenThenIsEmptyToken() {
        assertEquals(Token.NULL, this.playController.getToken(this.coordinate00));
    }
}