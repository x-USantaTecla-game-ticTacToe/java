package usantatecla.tictactoe.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import usantatecla.tictactoe.types.StateValue;
import usantatecla.tictactoe.types.Token;

public class SessionTest {

  private Session session;

  public SessionTest() {
    this.session = new Session();
  }

  @Test
  public void testGivenSessionWhenBornThenInitialValues() {
    this.session.setUsers(2);
    assertEquals(2, this.session.getMaxPlayers());
    assertEquals(Token.X, this.session.getToken());
    for (int i = 0; i < Coordinate.DIMENSION; i++) {
      for (int j = 0; j < Coordinate.DIMENSION; j++) {
        assertEquals(Token.NULL, this.session.getToken(new Coordinate(i, j)));
      }
    }
    assertFalse(this.session.isBoardComplete());
  }

  @Test
  public void testGivenSessionWhenMultiplyNextThenExit() {
    this.session.setUsers(1);
    assertEquals(StateValue.INITIAL, this.session.getValueState());
    this.session.next();
    assertEquals(StateValue.IN_GAME, this.session.getValueState());
    this.session.next();
    assertEquals(StateValue.RESUME, this.session.getValueState());
    this.session.next();
    assertEquals(StateValue.EXIT, this.session.getValueState());
  }

  @Test
  public void testGivenSessionWhenResetThenInitial() {
    this.session.setUsers(1);
    assertEquals(StateValue.INITIAL, this.session.getValueState());
    this.session.next();
    assertEquals(StateValue.IN_GAME, this.session.getValueState());
    this.session.next();
    assertEquals(StateValue.RESUME, this.session.getValueState());
    this.session.reset();
    assertEquals(StateValue.INITIAL, this.session.getValueState());
  }

  @Test
  public void testGivenSessionWhenPutMainDiagonalTokensThenTrue(){
    this.session.setUsers(0);
    assertEquals(Token.X, this.session.getToken());
    this.session.put(new Coordinate(0,0));
    assertEquals(Token.O, this.session.getToken());
    this.session.put(new Coordinate(0,1));
    assertEquals(Token.X, this.session.getToken());
    this.session.put(new Coordinate(1,1));
    assertEquals(Token.O, this.session.getToken());
    this.session.put(new Coordinate(1,2));
    assertEquals(Token.X, this.session.getToken());
    this.session.put(new Coordinate(2,2));
    assertEquals(Token.X, this.session.getToken());
    assertTrue(this.session.isTicTacToe());
  }
}