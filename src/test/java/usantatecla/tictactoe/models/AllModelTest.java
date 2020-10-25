package usantatecla.tictactoe.models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
    BoardTest.class, 
    CoordinateTest.class,
    GameMementoTest.class,
    GameRegistryTest.class,
    GameTest.class,
    PlayerTest.class,
    SessionTest.class, 
    StateTest.class,
    TurnTest.class } )
public class AllModelTest {
    
}