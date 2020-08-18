package usantatecla;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import usantatecla.tictactoe.AllTicTacToeTest;
import usantatecla.utils.AllUtilsTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
    AllTicTacToeTest.class, 
    AllUtilsTest.class } )
public class AllTest {
    
}