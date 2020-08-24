package usantatecla.tictactoe;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import usantatecla.tictactoe.controllers.implementation.AllControllerimplementationTest;
import usantatecla.tictactoe.models.AllModelTest;
import usantatecla.tictactoe.views.models.AllViewModelsTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ AllControllerimplementationTest.class,
    AllModelTest.class, 
    AllViewModelsTest.class } )
public class AllTicTacToeTest {
}