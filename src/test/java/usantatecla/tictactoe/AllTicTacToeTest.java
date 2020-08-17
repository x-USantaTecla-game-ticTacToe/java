package usantatecla.tictactoe;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
    BoardTest.class, 
    CoordinateTest.class,
    PlayerTest.class,
    TurnTest.class } )
public class AllTicTacToeTest {
    
}