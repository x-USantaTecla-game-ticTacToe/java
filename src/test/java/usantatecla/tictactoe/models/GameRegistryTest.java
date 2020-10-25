package usantatecla.tictactoe.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import usantatecla.tictactoe.types.Token;

public class GameRegistryTest {
  
  private GameRegistry registry;
  private Game game;

  public GameRegistryTest(){
    this.game = new Game();
    this.game.setUsers(2);
    this.registry = new GameRegistry(this.game);
  }

  @Test
  public void testGivenGameRegistryWhenUndoThenIsCorrect(){
    Coordinate first = new Coordinate(0,0);
    Coordinate second = new Coordinate(1,1);
    assertEquals(Token.NULL, this.game.getToken(first));
    assertEquals(Token.NULL, this.game.getToken(second));
    this.game.put(first);
    this.registry.register();
    assertEquals(Token.X, this.game.getToken(first));
    assertEquals(Token.NULL, this.game.getToken(second));
    this.game.put(second);
    this.registry.register();
    assertEquals(Token.X, this.game.getToken(first));
    assertEquals(Token.O, this.game.getToken(second));
    this.registry.undo();
    assertEquals(Token.X, this.game.getToken(first));
    assertEquals(Token.NULL, this.game.getToken(second));
    Coordinate third = new Coordinate(2,2);
    this.game.put(third);
    this.registry.register();
    assertEquals(Token.X, this.game.getToken(first));
    assertEquals(Token.NULL, this.game.getToken(second));
    assertEquals(Token.O, this.game.getToken(third));
  }


  @Test
  public void testGivenGameRegistryWhenUndoRedoThenIsCorrect(){
    Coordinate first = new Coordinate(1,1);
    this.game.put(first);
    this.registry.register();
    assertTrue(this.registry.isUndoable());
    this.registry.undo();
    assertEquals(Token.NULL, this.game.getToken(first));
    assertTrue(this.registry.isRedoable());
    this.registry.redo();
    assertEquals(Token.X, this.game.getToken(first));
    Coordinate second = new Coordinate(2,2); 
    this.game.put(second);
    this.registry.register();
    assertEquals(Token.X, this.game.getToken(first));
    assertEquals(Token.O, this.game.getToken(second));
    assertEquals(Token.X, this.game.getToken());
  }

  @Test
  public void testGivenGameRegistryWhenUndoRedoUndoRedoThenIsCorrect(){
    Coordinate first = new Coordinate(1,1);
    this.game.put(first);
    this.registry.register();
    assertEquals(Token.X, this.game.getToken(first));
    this.registry.undo();
    assertEquals(Token.NULL, this.game.getToken(first));
    this.registry.redo();
    assertEquals(Token.X, this.game.getToken(first));
    this.registry.undo();
    assertEquals(Token.NULL, this.game.getToken(first));
    this.registry.redo();
    assertEquals(Token.X, this.game.getToken(first));
    Coordinate second = new Coordinate(2,2);
    this.game.put(second);
    this.registry.register();
    assertEquals(Token.X, this.game.getToken(first));
    assertEquals(Token.O, this.game.getToken(second));
    assertEquals(Token.X, this.game.getToken());
  }

  @Test
  public void testGivenGameRegistryWhenUndoUndoRedoRedoThenIsCorrect(){
    Coordinate first = new Coordinate(0,0);
    Coordinate second = new Coordinate(1,1);
    assertEquals(Token.NULL, this.game.getToken(first));
    assertEquals(Token.NULL, this.game.getToken(second));
    this.game.put(first);
    this.registry.register();
    assertEquals(Token.X, this.game.getToken(first));
    assertEquals(Token.NULL, this.game.getToken(second));
    this.game.put(second);
    this.registry.register();
    assertEquals(Token.X, this.game.getToken(first));
    assertEquals(Token.O, this.game.getToken(second));
    this.registry.undo();
    assertEquals(Token.X, this.game.getToken(first));
    assertEquals(Token.NULL, this.game.getToken(second));
    this.registry.undo();
    assertEquals(Token.NULL, this.game.getToken(first));
    assertEquals(Token.NULL, this.game.getToken(second));
    this.registry.redo();
    assertEquals(Token.X, this.game.getToken(first));
    assertEquals(Token.NULL, this.game.getToken(second));
    this.registry.redo();
    assertEquals(Token.X, this.game.getToken(first));
    assertEquals(Token.O, this.game.getToken(second));
    Coordinate third = new Coordinate(2,2);
    this.game.put(third);
    this.registry.register();
    assertEquals(Token.X, this.game.getToken(first));
    assertEquals(Token.O, this.game.getToken(second));
    assertEquals(Token.X, this.game.getToken(third));
  }

  @Test
  public void testGivenGameRegistryWhenUndoUndoThenIsCorrect(){
    Coordinate first = new Coordinate(0,0);
    assertEquals(Token.NULL, this.game.getToken(first));
    this.game.put(first);
    this.registry.register();
    assertEquals(Token.X, this.game.getToken(first));

    Coordinate second = new Coordinate(1,1);
    assertEquals(Token.X, this.game.getToken(first));
    assertEquals(Token.NULL, this.game.getToken(second));
    this.game.put(second);
    this.registry.register();
    assertEquals(Token.X, this.game.getToken(first));
    assertEquals(Token.O, this.game.getToken(second));

    this.registry.undo();
    
    this.registry.undo();

    assertEquals(Token.NULL, this.game.getToken(first));
    assertEquals(Token.NULL, this.game.getToken(second));

    Coordinate third = new Coordinate(0,0);
    assertEquals(Token.NULL, this.game.getToken(third));
    this.game.put(third);
    this.registry.register();
    assertEquals(Token.NULL, this.game.getToken(second));
    assertEquals(Token.X, this.game.getToken(third));
  }

  @Test
  public void alskdjfaslk(){
    Coordinate first = new Coordinate(0,0);
    assertEquals(Token.NULL, this.game.getToken(first));
    this.game.put(first);
    this.registry.register();
    assertEquals(Token.X, this.game.getToken(first));

    this.registry.undo();

    Coordinate second = new Coordinate(1,1);
    assertEquals(Token.NULL, this.game.getToken(second));
    this.game.put(second);
    this.registry.register();
    assertEquals(Token.X, this.game.getToken(second));

    Coordinate third = new Coordinate(2,2);
    assertEquals(Token.NULL, this.game.getToken(third));
    this.game.put(third);
    this.registry.register();
    assertEquals(Token.O, this.game.getToken(third));

    this.registry.undo();

    Coordinate fourth = new Coordinate(2,0);
    assertEquals(Token.NULL, this.game.getToken(fourth));
    this.game.put(fourth);
    this.registry.register();
    assertEquals(Token.O, this.game.getToken(fourth));
    
    Coordinate fifth = new Coordinate(0,0);
    assertEquals(Token.NULL, this.game.getToken(fifth));
    this.game.put(fifth);
    this.registry.register();
    assertEquals(Token.X, this.game.getToken(fifth));

    assertEquals(Token.X, this.game.getToken(second));
    assertEquals(Token.O, this.game.getToken(fourth));
    assertEquals(Token.X, this.game.getToken(fifth));

    this.registry.undo();

    assertEquals(Token.X, this.game.getToken(second));
    assertEquals(Token.O, this.game.getToken(fourth));
    assertEquals(Token.NULL, this.game.getToken(fifth));

    this.registry.undo();

    assertEquals(Token.X, this.game.getToken(second));
    assertEquals(Token.NULL, this.game.getToken(fourth));
    assertEquals(Token.NULL, this.game.getToken(fifth));

  }

}
