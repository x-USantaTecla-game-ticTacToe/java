package usantatecla.tictactoe.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.Token;

public class GameTest {

    private Game game;

    public GameTest() {
        this.game = new Game();
    }

    @Test
    public void testGivenGameWhenPutTwoTokensInSameCoordinateThenNotEmptyError() {
      this.game.setUsers(0);
      Coordinate coordinate = new Coordinate(0,0);
      this.game.put(coordinate);
      assertEquals(Error.NOT_EMPTY, this.game.put(coordinate));
      assertEquals(Token.O, this.game.getToken());
    }

    @Test
    public void testGivenGameWhenMoveOppositeTokenThenNotOwnerError() {
      this.game.setUsers(0);
      Coordinate coordinate = new Coordinate(0,1);
      this.game.put(coordinate);
      assertEquals(Error.NOT_OWNER, this.game.move(coordinate, new Coordinate(2,2)));
      assertEquals(Token.O, this.game.getToken());
    }

    @Test
    public void testGivenGameWhenMoveInSameCoordinateThenSameCoordinateError() {
      Coordinate coordinate = new Coordinate(0,0);
      this.game.setUsers(0);
      this.game.put(coordinate);
      this.game.put(new Coordinate(2,1));
      assertEquals(Error.SAME_COORDINATES, this.game.move(coordinate, coordinate));
      assertEquals(Token.X, this.game.getToken());
    }
    
    @Test
    public void testGivenGameWhenMainDiagonalTicTacToeThenTrue() {
      this.game.setUsers(0);
      this.game.put(new Coordinate(0,0));
      this.game.put(new Coordinate(0,1));
      this.game.put(new Coordinate(1,1));
      this.game.put(new Coordinate(1,2));
      this.game.put(new Coordinate(2,2));
      assertFalse(this.game.isBoardComplete());
      assertTrue(this.game.isTicTacToe());
      assertEquals(Token.X, this.game.getToken());
    }

    @Test
    public void testGivenGameWhenPutSixTokensThenIsComplete() {
      this.game.setUsers(0);
      this.game.put(new Coordinate(0,0));
      this.game.put(new Coordinate(0,1));
      this.game.put(new Coordinate(1,1));
      this.game.put(new Coordinate(1,2));
      this.game.put(new Coordinate(2,0));
      assertFalse(this.game.isBoardComplete());
      this.game.put(new Coordinate(2,1));
      assertTrue(this.game.isBoardComplete());
      assertEquals(Token.X, this.game.getToken());
    }

    @Test
    public void testGivenGameWhenResetThenIsEmpty() {
      this.game.setUsers(0);
      this.game.put(new Coordinate(0,0));
      this.game.reset();
      this.game.setUsers(2);
      assertEquals(Token.NULL, this.game.getToken(new Coordinate(0,0)));
    }

  }