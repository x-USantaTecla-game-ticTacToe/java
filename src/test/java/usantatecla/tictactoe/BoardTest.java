package usantatecla.tictactoe;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BoardTest {

    private Board board;

    public BoardTest() {
        this.board = new Board(Turn.NUMBER_PLAYERS);
    }

    @Test
    public void testGivenNewBoardWhenPutNewTokenIsOccupiedThenIsTrue() {
    	assertTrue(this.board.isEmpty(new ConcreteCoordinate(0,0)));
        Token token = Token.get(0);
        ConcreteCoordinate coordinate = new ConcreteCoordinate(0, 0);
        this.board.put(coordinate, token);
        assertTrue(this.board.isOccupied(coordinate, token));
    }

    @Test
    public void testGivenNewBoardWhenPutNewTokenIsOccupiedThenIsFalse() {
        Token token = Token.values()[0];
        ConcreteCoordinate coordinate = new ConcreteCoordinate(0, 0);
        assertFalse(this.board.isOccupied(coordinate, token));
    }

    @Test
    public void testGivenNewBoardWhenMoveNewTokenIsOccupiedAndOriginIsEmptyThenIsTrue() {
        Token token = Token.values()[0];
        ConcreteCoordinate originCoordinate = new ConcreteCoordinate(0, 0);
        ConcreteCoordinate coordinateToMove = new ConcreteCoordinate(0, 1);
        this.board.put(originCoordinate, token);
        this.board.move(originCoordinate, coordinateToMove);
        assertTrue(this.board.isEmpty(originCoordinate));
        assertTrue(this.board.isOccupied(coordinateToMove, token));
    }

    @Test
    public void testGivenNewBoardWhenMoveNewTokenIsOccupiedAndOriginIsEmptyThenIsFalse() {
        Token token = Token.values()[0];
        ConcreteCoordinate originCoordinate = new ConcreteCoordinate(0, 0);
        ConcreteCoordinate coordinateToMove = new ConcreteCoordinate(0, 1);
        this.board.put(originCoordinate, token);
        this.board.move(originCoordinate, coordinateToMove);
        assertFalse(this.board.isEmpty(coordinateToMove));
        assertFalse(this.board.isOccupied(originCoordinate, token));
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewBoardWhenMoveNewTokenTheOriginIsEmptyThenAssertionException() {
        ConcreteCoordinate originCoordinate = new ConcreteCoordinate(0, 0);
        ConcreteCoordinate coordinateToMove = new ConcreteCoordinate(0, 1);
        this.board.move(originCoordinate, coordinateToMove);
    }

    @Test
    public void testGivenNewBoardWhenPutThreeTokenAndIsTicTacToeThenIsTrue() {
        Token token = Token.values()[0];
        ConcreteCoordinate coordinate11 = new ConcreteCoordinate(0, 0);
        ConcreteCoordinate coordinate12 = new ConcreteCoordinate(0, 1);
        ConcreteCoordinate coordinate13 = new ConcreteCoordinate(0, 2);
        this.board.put(coordinate11, token);
        this.board.put(coordinate12, token);
        this.board.put(coordinate13, token);
        assertTrue(this.board.isTicTacToe(token));
    }

    @Test
    public void testGivenNewBoardWhenPutTwoTokenAndIsTicTacToeThenIsFalse() {
        Token token = Token.values()[0];
        ConcreteCoordinate coordinate11 = new ConcreteCoordinate(0, 0);
        ConcreteCoordinate coordinate12 = new ConcreteCoordinate(0, 1);
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
        ConcreteCoordinate coordinate11 = new ConcreteCoordinate(0, 0);
        ConcreteCoordinate coordinate21 = new ConcreteCoordinate(1, 0);
        ConcreteCoordinate coordinate12 = new ConcreteCoordinate(0, 1);
        ConcreteCoordinate coordinate22 = new ConcreteCoordinate(1, 1);
        ConcreteCoordinate coordinate23 = new ConcreteCoordinate(1, 2);
        ConcreteCoordinate coordinate33 = new ConcreteCoordinate(2, 2);
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
        ConcreteCoordinate coordinate11 = new ConcreteCoordinate(0, 0);
        ConcreteCoordinate coordinate21 = new ConcreteCoordinate(1, 0);
        ConcreteCoordinate coordinate12 = new ConcreteCoordinate(0, 1);
        ConcreteCoordinate coordinate22 = new ConcreteCoordinate(1, 1);
        ConcreteCoordinate coordinate23 = new ConcreteCoordinate(1, 2);
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
