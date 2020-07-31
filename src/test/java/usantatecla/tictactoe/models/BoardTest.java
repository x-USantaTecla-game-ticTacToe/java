package usantatecla.tictactoe.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import usantatecla.tictactoe.types.Token;

public class BoardTest {

    private Board board;

    public BoardTest() {
        this.board = new Board();
    }

    @Test
    public void testGivenNewBoardThenPutNewTokenIsOccupied() {
        Token token = Token.values()[0];
        Coordinate coordinate = new Coordinate(1, 1);
        this.board.put(coordinate, token);
        assertTrue(this.board.isOccupied(coordinate, token));
    }

    @Test
    public void testGivenNewBoardThenMoveNewTokenIsOccupied() {
        Token token = Token.values()[0];
        Coordinate originCoordinate = new Coordinate(1, 1);
        Coordinate coordinateToMove = new Coordinate(1, 2);
        this.board.put(originCoordinate, token);
        this.board.move(originCoordinate, coordinateToMove);
        assertTrue(this.board.isEmpty(originCoordinate));
        assertTrue(this.board.isOccupied(coordinateToMove, token));
    }

    @Test
    public void testGivenNewBoardThenPutThreeTokenAndIsTicTacToe() {
        Token token = Token.values()[0];
        Coordinate coordinate11 = new Coordinate(1, 1);
        Coordinate coordinate12 = new Coordinate(1, 2);
        Coordinate coordinate13 = new Coordinate(1, 3);
        this.board.put(coordinate11, token);
        this.board.put(coordinate12, token);
        this.board.put(coordinate13, token);
        assertTrue(this.board.isTicTacToe(token));
    }

    @Test
    public void testGivenNewBoardThenPutSixTokensAndIsCompleted() {
        Token tokenX = Token.values()[0];
        Token tokenO = Token.values()[1];
        Coordinate coordinate11 = new Coordinate(1, 1);
        Coordinate coordinate21 = new Coordinate(2, 1);
        Coordinate coordinate12 = new Coordinate(1, 2);
        Coordinate coordinate22 = new Coordinate(2, 2);
        Coordinate coordinate23 = new Coordinate(2, 3);
        Coordinate coordinate33 = new Coordinate(3, 3);
        this.board.put(coordinate11, tokenX);
        this.board.put(coordinate21, tokenO);
        this.board.put(coordinate12, tokenX);
        this.board.put(coordinate22, tokenO);
        this.board.put(coordinate23, tokenX);
        this.board.put(coordinate33, tokenO);
        assertTrue(this.board.isCompleted());
    }

    @Test
    public void testGivenNewBoardThenPutNewTokenAndGetToken() {
        Token token = Token.values()[0];
        Coordinate coordinate = new Coordinate(1, 1);
        this.board.put(coordinate, token);
        assertEquals(token, this.board.getToken(coordinate));
    }
}
