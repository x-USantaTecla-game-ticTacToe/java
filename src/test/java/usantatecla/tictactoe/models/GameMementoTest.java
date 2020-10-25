package usantatecla.tictactoe.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import usantatecla.tictactoe.types.Token;

public class GameMementoTest {
  
  private GameMemento memento;
  private Board board;
  private Turn turn;

  public GameMementoTest(){
    this.board = new Board();
    this.turn = new Turn(this.board);
    this.turn.setUsers(2);
    this.memento = new GameMemento(this.turn, this.board);
  }

  @Test
  public void testGivenGameMementoThenIsEqualsToOriginBoard(){
    assertFalse(this.board == this.memento.getBoard());
    assertFalse(this.turn == this.memento.getTurn());
    assertFalse(this.turn.getPlayer() == this.memento.getTurn().getPlayer());
    assertFalse(this.turn.getPlayer().board == this.memento.getTurn().getPlayer().board);
    
    assertTrue(this.turn.getPlayer().getToken() == this.memento.getTurn().getPlayer().getToken());
    assertEquals(this.board, this.memento.getBoard());
    assertEquals(this.turn, this.memento.getTurn());
  }

  @Test
  public void testGivenGameMementoWhenPutThenIsEqualsToOriginBoard(){
    Coordinate coordinate = new Coordinate(0,0);
    this.board.put(coordinate, Token.X);
    this.memento = new GameMemento(turn, board);
    assertFalse(this.board == this.memento.getBoard());
    assertFalse(this.turn == this.memento.getTurn());
    assertFalse(this.turn.getPlayer() == this.memento.getTurn().getPlayer());
    assertFalse(this.turn.getPlayer().board == this.memento.getTurn().getPlayer().board);
    
    assertTrue(this.turn.getPlayer().getToken() == this.memento.getTurn().getPlayer().getToken());
    assertEquals(this.board, this.memento.getBoard());
    assertEquals(this.turn, this.memento.getTurn());

    assertEquals(Token.X, this.board.getToken(coordinate));
    assertEquals(Token.X, this.memento.getBoard().getToken(coordinate));
  }

}
