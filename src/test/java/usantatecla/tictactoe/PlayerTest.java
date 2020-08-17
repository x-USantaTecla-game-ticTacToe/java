package usantatecla.tictactoe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PlayerTest {
    
    private Board board;

    private Player player;

    private Coordinate coordinate11;
    private Coordinate coordinate12;

    public PlayerTest() {
        this.board = new Board();
        this.player = new UserPlayer(Token.TOKEN_O, this.board);
        this.coordinate11 = new Coordinate(1, 1);
        this.coordinate12 = new Coordinate(1, 2);
    }

    @Test
    public void testGivenNewPlayerThenPutNewTokenReturnErrorNotOwner() {
        this.board.put(this.coordinate11, Token.TOKEN_O);
        assertEquals(Error.NOT_OWNER, this.player.getErrorsPutCoordinate(this.coordinate11));
    }

    @Test
    public void testGivenNewPlayerThenPutNewTokenNotReturnErrorNull() {
        this.board.put(this.coordinate11, Token.TOKEN_O);
        assertTrue(this.player.getErrorsPutCoordinate(this.coordinate12) == null);
    }

    @Test
    public void testGivenNewPlayerThenRemoveTokenReturnErrorNotOwner() {
        this.board.put(this.coordinate11, Token.TOKEN_O);
        assertEquals(Error.NOT_OWNER, this.player.getErrorsMoveOriginCoordinate(this.coordinate12));
    }

    @Test
    public void testGivenNewPlayerThenRemoveTokenNotReturnErrorNull() {
        this.board.put(this.coordinate11, Token.TOKEN_O);
        assertTrue(this.player.getErrorsMoveOriginCoordinate(this.coordinate11) == null);
    }

    @Test
    public void testGivenNewPlayerThenMoveTokenReturnErrorSameCoordinates() {
        this.board.put(this.coordinate11, Token.TOKEN_O);
        assertEquals(Error.SAME_COORDINATES, this.player.getErrorsMoveTargetCoordinate(this.coordinate11, this.coordinate11));
    }

    @Test
    public void testGivenNewPlayerThenMoveTokenReturnErrorNotEmpty() {
        this.board.put(this.coordinate11, Token.TOKEN_O);
        this.board.put(this.coordinate12, Token.TOKEN_O);
        assertEquals(Error.NOT_EMPTY, this.player.getErrorsMoveTargetCoordinate(this.coordinate11, this.coordinate12));
    }

    @Test
    public void testGivenNewPlayerThenMoveTokenNotReturnErrorNull() {
        this.board.put(this.coordinate11, Token.TOKEN_O);
        assertTrue(this.player.getErrorsMoveTargetCoordinate(this.coordinate11, this.coordinate12) == null);
    }
}