package usantatecla.tictactoe.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.Token;

public class PlayerTest {
    
    private Board board;

    private Player player;

    private Coordinate coordinate11;
    private Coordinate coordinate12;

    public PlayerTest() {
        this.board = new Board();
        this.player = new Player(Token.TOKEN_O, this.board, PlayerType.USER_PLAYER);
        this.coordinate11 = new Coordinate(1, 1);
        this.coordinate12 = new Coordinate(1, 2);
    }

    @Test
    public void testGivenNewPlayerThenPutNewTokenReturnErrorNotOwner() {
        this.board.put(this.coordinate11, Token.TOKEN_O);
        assertEquals(Error.NOT_OWNER, this.player.controlErrorsPutCoordinate(this.coordinate11));
    }

    @Test
    public void testGivenNewPlayerThenPutNewTokenNotReturnErrorNull() {
        this.board.put(this.coordinate11, Token.TOKEN_O);
        assertTrue(this.player.controlErrorsPutCoordinate(this.coordinate12) == null);
    }

    @Test
    public void testGivenNewPlayerThenRemoveTokenReturnErrorNotOwner() {
        this.board.put(this.coordinate11, Token.TOKEN_O);
        assertEquals(Error.NOT_OWNER, this.player.controlErrorsMoveOriginCoordinate(this.coordinate12));
    }

    @Test
    public void testGivenNewPlayerThenRemoveTokenNotReturnErrorNull() {
        this.board.put(this.coordinate11, Token.TOKEN_O);
        assertTrue(this.player.controlErrorsMoveOriginCoordinate(this.coordinate11) == null);
    }

    @Test
    public void testGivenNewPlayerThenMoveTokenReturnErrorSameCoordinates() {
        this.board.put(this.coordinate11, Token.TOKEN_O);
        assertEquals(Error.SAME_COORDINATES, this.player.controlErrorsMoveTargetCoordinate(this.coordinate11, this.coordinate11));
    }

    @Test
    public void testGivenNewPlayerThenMoveTokenReturnErrorNotEmpty() {
        this.board.put(this.coordinate11, Token.TOKEN_O);
        this.board.put(this.coordinate12, Token.TOKEN_O);
        assertEquals(Error.NOT_EMPTY, this.player.controlErrorsMoveTargetCoordinate(this.coordinate11, this.coordinate12));
    }

    @Test
    public void testGivenNewPlayerThenMoveTokenNotReturnErrorNull() {
        this.board.put(this.coordinate11, Token.TOKEN_O);
        assertTrue(this.player.controlErrorsMoveTargetCoordinate(this.coordinate11, this.coordinate12) == null);
    }
}