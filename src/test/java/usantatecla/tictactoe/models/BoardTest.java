package usantatecla.tictactoe.models;

import static org.junit.Assert.assertEquals;
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
    public void testGivenEmptyBoardWhenCopyThenEquals() {
        assertEquals(this.board.copy(), this.board);
    }

    @Test
    public void testGivenBoardWithTwoTokensWhenCopyThenEquals() {
        this.board.put(new Coordinate(1,0), Token.X);
        this.board.put(new Coordinate(2,2), Token.O);
        assertEquals(this.board.copy(), this.board);
    }

    @Test
    public void testGivenNewBoardWhenPutNewTokenThenIsOccupied() {
        Token token = Token.X;
        Coordinate coordinate = new Coordinate(0, 0);
        this.board.put(coordinate, token);
        assertTrue(this.board.isOccupied(coordinate, token));
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

    @Test
    public void testGivenNewBoardWhenNoActionsThenAllEmpty() {
        assertTrue(this.board.isEmpty(new Coordinate(0, 0)));
        assertTrue(this.board.isEmpty(new Coordinate(2, 2)));
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
    public void testGivenNewBoardWhenPutThreeTokenAndNotIsTicTacToeThenIsFalse() {
        Token token = Token.X;
        this.board.put(new Coordinate(0, 0), token);
        this.board.put(new Coordinate(2, 0), token);
        this.board.put(new Coordinate(0, 2), token);
        assertFalse(this.board.isTicTacToe(token));
    }

    @Test
    public void testGivenNewBoardWhenPutThreeTokenAndRowThenIsTrue() {
        Token token = Token.X;
        this.board.put(new Coordinate(0, 0), token);
        this.board.put(new Coordinate(0, 1), token);
        this.board.put(new Coordinate(0, 2), token);
        assertTrue(this.board.isTicTacToe(token));
    }

    @Test
    public void testGivenNewBoardWhenPutThreeTokenAndColumnThenIsTrue() {
        Token token = Token.X;
        this.board.put(new Coordinate(2, 2), token);
        this.board.put(new Coordinate(1, 2), token);
        this.board.put(new Coordinate(0, 2), token);
        assertTrue(this.board.isTicTacToe(token));
    }

    @Test
    public void testGivenNewBoardWhenPutThreeTokenAndMainDiagonalThenIsTrue() {
        Token token = Token.X;
        this.board.put(new Coordinate(2, 2), token);
        this.board.put(new Coordinate(0, 0), token);
        this.board.put(new Coordinate(1, 1), token);
        assertTrue(this.board.isTicTacToe(token));
    }

    @Test
    public void testGivenNewBoardWhenPutThreeTokenAndInverseDiagonalThenIsTrue() {
        Token token = Token.X;
        this.board.put(new Coordinate(0, 2), token);
        this.board.put(new Coordinate(2, 0), token);
        this.board.put(new Coordinate(1, 1), token);
        assertTrue(this.board.isTicTacToe(token));
    }

    @Test
    public void testGivenNewBoardWhenPutTwoTokenAndNotIsTicTacToeThenIsFalse() {
        Token token = Token.X;
        this.board.put(new Coordinate(0, 0), token);
        this.board.put(new Coordinate(0, 1), token);
        this.board.put(new Coordinate(1, 2), token);
        assertFalse(this.board.isTicTacToe(token));
    }

    @Test
    public void testGivenNewBoardWhenPutTwoTokenAndNotIsCompletedThenIsFalse() {
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
    public void testGivenNewBoardWhenNotPutTokensAndIsCompletedThenIsFalse() {
        assertFalse(this.board.isCompleted());
    }
}
