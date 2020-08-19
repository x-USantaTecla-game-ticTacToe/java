package usantatecla.tictactoe.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BoardTest {

    private Board board;

    public BoardTest() {
        this.board = new Board();
    }

    @Test
    public void testGivenNewBoardWhenPutNewTokenIsOccupiedThenIsTrue() {
        Token token = Token.values()[0];
        Coordinate coordinate = new Coordinate(0, 0);
        this.board.put(coordinate, token);
        assertTrue(this.board.isOccupied(coordinate, token));
    }

    @Test
    public void testGivenNewBoardWhenPutNewTokenIsOccupiedThenIsFalse() {
        Token token = Token.values()[0];
        Coordinate coordinate = new Coordinate(0, 0);
        assertFalse(this.board.isOccupied(coordinate, token));
    }

    @Test
    public void testGivenNewBoardWhenMoveNewTokenIsOccupiedAndOriginIsEmptyThenIsTrue() {
        Token token = Token.values()[0];
        Coordinate originCoordinate = new Coordinate(0, 0);
        Coordinate coordinateToMove = new Coordinate(0, 1);
        this.board.put(originCoordinate, token);
        this.board.move(originCoordinate, coordinateToMove);
        assertTrue(this.board.isEmpty(originCoordinate));
        assertTrue(this.board.isOccupied(coordinateToMove, token));
    }

    @Test
    public void testGivenNewBoardWhenMoveNewTokenIsOccupiedAndOriginIsEmptyThenIsFalse() {
        Token token = Token.values()[0];
        Coordinate originCoordinate = new Coordinate(0, 0);
        Coordinate coordinateToMove = new Coordinate(0, 1);
        this.board.put(originCoordinate, token);
        this.board.move(originCoordinate, coordinateToMove);
        assertFalse(this.board.isEmpty(coordinateToMove));
        assertFalse(this.board.isOccupied(originCoordinate, token));
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewBoardWhenMoveNewTokenTheOriginIsEmptyThenAssertionException() {
        Coordinate originCoordinate = new Coordinate(0, 0);
        Coordinate coordinateToMove = new Coordinate(0, 1);
        this.board.move(originCoordinate, coordinateToMove);
    }

    @Test
    public void testGivenNewBoardWhenPutThreeTokenAndIsTicTacToeThenIsTrue() {
        Token token = Token.values()[0];
        Coordinate coordinate11 = new Coordinate(0, 0);
        Coordinate coordinate12 = new Coordinate(0, 1);
        Coordinate coordinate13 = new Coordinate(0, 2);
        this.board.put(coordinate11, token);
        this.board.put(coordinate12, token);
        this.board.put(coordinate13, token);
        assertTrue(this.board.isTicTacToe(token));
    }

    @Test
    public void testGivenNewBoardWhenPutTwoTokenAndIsTicTacToeThenIsFalse() {
        Token token = Token.values()[0];
        Coordinate coordinate11 = new Coordinate(0, 0);
        Coordinate coordinate12 = new Coordinate(0, 1);
        this.board.put(coordinate11, token);
        this.board.put(coordinate12, token);
        assertFalse(this.board.isTicTacToe(token));
    }

    @Test
    public void testGivenNewBoardWhenNotPutTokensAndIsTicTacToeThenIsFalse() {
        Token token = Token.values()[0];
        assertFalse(this.board.isTicTacToe(token));
    }

    @Test
    public void testGivenNewBoardWhenPutSixTokensAndIsCompletedThenIsTrue() {
        Token tokenX = Token.values()[0];
        Token tokenO = Token.values()[1];
        Coordinate coordinate11 = new Coordinate(0, 0);
        Coordinate coordinate21 = new Coordinate(1, 0);
        Coordinate coordinate12 = new Coordinate(0, 1);
        Coordinate coordinate22 = new Coordinate(1, 1);
        Coordinate coordinate23 = new Coordinate(1, 2);
        Coordinate coordinate33 = new Coordinate(2, 2);
        this.board.put(coordinate11, tokenX);
        this.board.put(coordinate21, tokenO);
        this.board.put(coordinate12, tokenX);
        this.board.put(coordinate22, tokenO);
        this.board.put(coordinate23, tokenX);
        this.board.put(coordinate33, tokenO);
        assertTrue(this.board.isCompleted());
    }

    @Test
    public void testGivenNewBoardWhenPutFiveTokensAndIsCompletedThenIsFalse() {
        Token tokenX = Token.values()[0];
        Token tokenO = Token.values()[1];
        Coordinate coordinate11 = new Coordinate(0, 0);
        Coordinate coordinate21 = new Coordinate(1, 0);
        Coordinate coordinate12 = new Coordinate(0, 1);
        Coordinate coordinate22 = new Coordinate(1, 1);
        Coordinate coordinate23 = new Coordinate(1, 2);
        this.board.put(coordinate11, tokenX);
        this.board.put(coordinate21, tokenO);
        this.board.put(coordinate12, tokenX);
        this.board.put(coordinate22, tokenO);
        this.board.put(coordinate23, tokenX);
        assertFalse(this.board.isCompleted());
    }

    @Test
    public void testGivenNewBoardWhenNotPutTokensAndIsCompletedThenIsFalse() {
        assertFalse(this.board.isCompleted());
    }
}
