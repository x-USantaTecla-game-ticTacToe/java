package usantatecla.tictactoe.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.Token;

public class PlayerTest {

  private Player player;
  private Token token;
  private Board board;

  public PlayerTest() {
    this.board = new Board();
    this.token = Token.X;
    this.player = new Player(this.token, this.board);
  }

  @Test
  public void testGivenPlayerWhenPutThenTokenIsThere() {
    Coordinate coordinate = new Coordinate(1, 0);
    assertEquals(Error.NULL, this.player.put(coordinate));
    assertEquals(this.token, this.board.getToken(coordinate));
  }

  @Test
  public void testGivenPlayerWhenPutAndOccupiedThenNotEmptyError() {
    Coordinate coordinate = new Coordinate(1, 0);
    this.player.put(coordinate);
    assertEquals(Error.NOT_EMPTY, this.player.put(coordinate));
    assertEquals(this.token, this.board.getToken(coordinate));
  }

  @Test
  public void testGivenPlayerWhenMoveThenTokenIsThere() {
    Coordinate origin = new Coordinate(1, 0);
    Coordinate target = new Coordinate(1, 1);
    this.player.put(origin);
    assertEquals(Error.NULL, this.player.move(origin, target));
    assertEquals(Token.NULL, this.board.getToken(origin));
    assertEquals(this.token, this.board.getToken(target));
  }

  @Test
  public void testGivenPlayerWhenMoveEmptyThenNotOwnerError() {
    assertEquals(Error.NOT_OWNER, this.player.move(new Coordinate(1, 0), new Coordinate(1, 1)));
  }

  @Test
  public void testGivenPlayerWhenMoveOccupiedOriginByOppositeThenNotOwnerError() {
    Coordinate origin = new Coordinate(1, 0);
    Coordinate target = new Coordinate(1, 1);
    new Player(Token.O, this.board).put(origin);
    assertEquals(Error.NOT_OWNER, this.player.move(origin, target));
  }

  @Test
  public void testGivenPlayerWhenMoveOccupiedTargetThenNotEmptyError() {
    Coordinate origin = new Coordinate(1, 0);
    Coordinate target = new Coordinate(1, 1);
    this.player.put(origin);
    new Player(Token.O, this.board).put(target);
    assertEquals(Error.NOT_EMPTY, this.player.move(origin, target));
  }

}
