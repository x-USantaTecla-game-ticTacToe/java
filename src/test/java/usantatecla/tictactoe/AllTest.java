package usantatecla.tictactoe;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import usantatecla.tictactoe.models.AllModelTest;
import usantatecla.tictactoe.views.console.AllViewTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
    AllModelTest.class, 
    AllViewTest.class } )
public class AllTest {
}