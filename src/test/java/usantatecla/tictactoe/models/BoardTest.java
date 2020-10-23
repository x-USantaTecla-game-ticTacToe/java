package usantatecla.tictactoe.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import usantatecla.tictactoe.types.Token;

public class BoardTest {

    private Board board;

    public BoardTest() {
        this.board = new Board();
    }

    @Test
    public void testGivenNewBoardWhenPutNewTokenIsOccupiedThenIsTrue() {
        Token token = Token.X;
        Coordinate coordinate = new Coordinate(0, 0);
        this.board.put(coordinate, token);
        assertTrue(this.board.isOccupied(coordinate, token));
    }

    @Test
    public void testGivenNewBoardWhenPutNewTokenIsOccupiedThenIsFalse() {
        Token token = Token.O;
        Coordinate coordinate = new Coordinate(2, 2);
        assertFalse(this.board.isOccupied(coordinate, token));
    }

    @Test
    public void testGivenNewBoardWhenMoveNewTokenIsOccupiedAndOriginIsEmptyThenIsTrue() {
        Token token = Token.O;
        Coordinate origin = new Coordinate(0, 1);
        Coordinate target = new Coordinate(0, 0);
        this.board.put(origin, token);
        this.board.move(origin, target);
        assertTrue(this.board.isEmpty(origin));
        assertTrue(this.board.isOccupied(target, token));
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewBoardWhenMoveNewTokenIsOccupiedAndOriginIsEmptyThenIsFalse() {
        Token token = Token.O;
        Coordinate origin = new Coordinate(0, 0);
        Coordinate target = new Coordinate(0, 1);
        this.board.put(target, token);
        this.board.move(origin, target);
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewBoardWhenMoveNewTokenTheOriginIsEmptyThenAssertionException() {
        this.board.move(new Coordinate(0, 0), new Coordinate(0, 1));
    }

    @Test
    public void testGivenNewBoardWhenPutThreeTokenAndIsTicTacToeThenIsTrue() {
        Token token = Token.X;
        this.board.put(new Coordinate(0, 0), token);
        this.board.put(new Coordinate(0, 1), token);
        this.board.put(new Coordinate(0, 2), token);
        assertTrue(this.board.isTicTacToe(token));
    }

    @Test
    public void testGivenNewBoardWhenPutTwoTokenAndIsTicTacToeThenIsFalse() {
        Token token = Token.X;
        this.board.put(new Coordinate(0, 0), token);
        this.board.put(new Coordinate(0, 1), token);
        assertFalse(this.board.isTicTacToe(token));
    }

    @Test
    public void testGivenNewBoardWhenNotPutTokensAndIsTicTacToeThenIsFalse() {
        assertFalse(this.board.isTicTacToe(Token.O));
        assertFalse(this.board.isTicTacToe(Token.X));
    }

    @Test
    public void testGivenNewBoardWhenPutSixTokensAndIsCompletedThenIsTrue() {
        Token tokenX = Token.X;
        Token tokenO = Token.O;
        this.board.put(new Coordinate(0, 0), tokenX);
        this.board.put(new Coordinate(1, 0), tokenO);
        this.board.put(new Coordinate(0, 1), tokenX);
        this.board.put(new Coordinate(1, 1), tokenO);
        this.board.put(new Coordinate(1, 2), tokenX);
        this.board.put(new Coordinate(2, 2), tokenO);
        assertTrue(this.board.isCompleted());
    }

    @Test
    public void testGivenNewBoardWhenPutFiveTokensAndIsCompletedThenIsFalse() {
        Token tokenX = Token.X;
        Token tokenO = Token.O;
        this.board.put(new Coordinate(0, 0), tokenX);
        this.board.put(new Coordinate(1, 0), tokenO);
        this.board.put(new Coordinate(0, 1), tokenX);
        this.board.put(new Coordinate(1, 1), tokenO);
        this.board.put(new Coordinate(1, 2), tokenX);
        assertFalse(this.board.isCompleted());
    }

    @Test
    public void testGivenNewBoardWhenNotPutTokensAndIsCompletedThenIsFalse() {
        assertFalse(this.board.isCompleted());
    }
}
