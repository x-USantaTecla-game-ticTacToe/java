package usantatecla.tictactoe.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import usantatecla.tictactoe.types.Token;
import usantatecla.tictactoe.types.Error;

public class TurnTest {

    private Turn turn;
    private Board board;

    public TurnTest() {
        this.board = new Board();
        this.turn = new Turn(board);
    }

    @Test
    public void testGivenTurnWhenTwiceNextThenSamePlayer() {
        this.turn.setUsers(2);
        assertEquals(Token.X, this.turn.getToken());
        this.turn.next();
        assertEquals(Token.O, this.turn.getToken());
        this.turn.next();
        assertEquals(Token.X, this.turn.getToken());
    }

    @Test
    public void testGivenNewTurnWhenTwoUsersThenTwoIsUsers() {
        this.turn.setUsers(2);
        assertTrue(this.turn.isUser());
        this.turn.next();
        assertTrue(this.turn.isUser());
        this.turn.next();
        assertTrue(this.turn.isUser());
    }

    @Test
    public void testGivenNewTurnWhenOneUsersThenOneIsUsers() {
        this.turn.setUsers(1);
        assertTrue(this.turn.isUser());
        this.turn.next();
        assertFalse(this.turn.isUser());
        this.turn.next();
        assertTrue(this.turn.isUser());
    }

    @Test
    public void testGivenNewTurnWhenZeroUsersThenZeroIsUsers() {
        this.turn.setUsers(0);
        assertFalse(this.turn.isUser());
        this.turn.next();
        assertFalse(this.turn.isUser());
        this.turn.next();
        assertFalse(this.turn.isUser());
    }

    @Test
    public void testGivenNewTurnWhenPutOnEmptyThenIsOccupied() {
        this.turn.setUsers(2);
        assertEquals(Token.X, this.turn.getToken());
        Coordinate coordinate1 = new Coordinate(0,2);
        this.turn.put(coordinate1);
        assertEquals(Token.X, this.board.getToken(coordinate1));
        this.turn.next();
        assertEquals(Token.O, this.turn.getToken());
        Coordinate coordinate2 = new Coordinate(0,1);
        this.turn.put(coordinate2);
        assertEquals(Token.O, this.board.getToken(coordinate2));
    }

    @Test
    public void testGivenNewTurnWhenPutOnOccupiedThenAssertionError() {
        this.turn.setUsers(2);
        assertEquals(Token.X, this.turn.getToken());
        Coordinate coordinate = new Coordinate(0,2);
        this.turn.put(coordinate);
        assertEquals(Token.X, this.board.getToken(coordinate));
        this.turn.next();
        assertEquals(Token.O, this.turn.getToken());
        assertEquals(Error.NOT_EMPTY, this.turn.put(coordinate));
    }

    @Test
    public void testGivenNewTurnWhenPutOnOccupiedThenAssertionError2() {
        this.turn.setUsers(2);
        Coordinate coordinate = new Coordinate(0,2);
        this.turn.put(coordinate);
        this.turn.next();
        this.turn.put(new Coordinate(2,0));
        this.turn.next();
        assertEquals(Error.SAME_COORDINATES, turn.move(coordinate, coordinate));
    }

}
