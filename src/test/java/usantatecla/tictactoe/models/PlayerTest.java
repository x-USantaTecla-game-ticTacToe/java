package usantatecla.tictactoe.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PlayerTest {
    
    private Board board;

    private Player player;

    private Coordinate coordinate00;
    private Coordinate coordinate01;

    public PlayerTest() {
        this.board = new Board();
        this.player = new Player(Token.O, this.board);
        this.coordinate00 = new Coordinate(0, 0);
        this.coordinate01 = new Coordinate(0, 1);
    }

    @Test
    public void testGivenNewPlayerWhenPutNewTokenThenReturnErrorNotOwner() {
        this.board.put(this.coordinate00, Token.O);
        assertEquals(Error.NOT_OWNER, this.player.put(this.coordinate00));
    }

    @Test
    public void testGivenNewPlayerWhenPutNewTokenThenNotReturnErrorNull() {
        this.board.put(this.coordinate00, Token.O);
        assertEquals(Error.NULL, this.player.put(this.coordinate01));
    }

    @Test
    public void testGivenNewPlayerWhenMoveTokenThenReturnErrorSameCoordinates() {
        this.board.put(this.coordinate00, Token.O);
        assertEquals(Error.NOT_EMPTY, this.player.move(this.coordinate00, this.coordinate00));
    }

    @Test
    public void testGivenNewPlayerWhenMoveTokenThenReturnErrorNotEmpty() {
        this.board.put(this.coordinate00, Token.O);
        this.board.put(this.coordinate01, Token.O);
        assertEquals(Error.NOT_EMPTY, this.player.move(this.coordinate00, this.coordinate01));
    }

    @Test
    public void testGivenNewPlayerWhenMoveTokenThenNotReturnErrorNull() {
        this.board.put(this.coordinate00, Token.O);
        assertEquals(Error.NULL, this.player.move(this.coordinate00, this.coordinate01));
    }
}