package usantatecla.tictactoe;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BoardTest {

    private Board board;

    public BoardTest() {
        this.board = new Board();
    }

    @Test
    public void testGivenNewBoardWhenStartThenIsEmpty() {
    	assertTrue(this.board.isEmpty(new Coordinate(0,0)));
    	assertTrue(this.board.isEmpty(new Coordinate(2,2)));
    }

    @Test
    public void testGivenNewBoardWhenPutNewTokenIsOccupiedThenIsFalse() {
        assertFalse(this.board.isOccupied(new Coordinate(0, 0), Token.X));
        assertFalse(this.board.isOccupied(new Coordinate(0, 0), Token.O));
    }

    @Test
    public void testGivenNewBoardWhenPutNewTokenIsOccupiedThenIsTrue() {
        Token token = Token.O;
        Coordinate coordinate = new Coordinate(0, 2);
        this.board.put(coordinate, token);
        assertTrue(this.board.isOccupied(coordinate, token));
    }

    @Test
    public void testGivenNewBoardWhenMoveNewTokenIsOccupiedAndOriginIsEmptyThenIsTrue() {
        Token token = Token.O;
        Coordinate origin = new Coordinate(0, 0);
        this.board.put(origin, token);
        Coordinate target = new Coordinate(0, 1);
        this.board.move(origin, target);
        assertTrue(this.board.isEmpty(origin));
        assertTrue(this.board.isOccupied(target, token));
    }

    @Test
    public void testGivenNewBoardWhenNotPutTokensAndIsTicTacToeThenIsFalse() {
        assertFalse(this.board.isTicTacToe(Token.O));
    }

    @Test
    public void testGivenNewBoardWhenPutThreeTokenAndIsTicTacToeThenIsTrue() {
        Token token = Token.O;
        for(int i=0; i<Coordinate.DIMENSION; i++){
            this.board.put(new Coordinate(i,2), token);
        }
        assertTrue(this.board.isTicTacToe(token));
    }

    @Test
    public void testGivenNewBoardWhenPutTwoTokenAndIsTicTacToeThenIsFalse() {
        Token token = Token.O;
        for(int i=0; i<Coordinate.DIMENSION - 1; i++){
            this.board.put(new Coordinate(i,2), token);
        }
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
