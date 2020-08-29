package usantatecla.tictactoe.views.console;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.State;
import usantatecla.utils.Console;

@RunWith(MockitoJUnitRunner.class)
public class CoordinateViewTest {
    static final String ENTER_COORDINATE_TO_PUT = "Enter a coordinate to put a token:";

    @Mock
    Console console;

    @InjectMocks
    CoordinateView coordinateView = new CoordinateView(new PlayController(new Game(), new State()));

    @Test
    public void testGivenNewCoordinateViewWhenReadCoordinateThenIsCorrect() {
        when(this.console.readInt("Row: ")).thenReturn(1);
        when(this.console.readInt("Column: ")).thenReturn(1);
        Coordinate coordinateRead = this.coordinateView.read(ENTER_COORDINATE_TO_PUT);
        Coordinate coordinateExpected = new Coordinate(0, 0);
        assertEquals(coordinateExpected.getRow(), coordinateRead.getRow());
        assertEquals(coordinateExpected.getColumn(), coordinateRead.getColumn());
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewCoordinatesWhenRow4AndColumn4ThenAssertionException() {
        when(this.console.readInt("Row: ")).thenReturn(4);
        when(this.console.readInt("Column: ")).thenReturn(4);
        this.coordinateView.read("Title");
        verify(this.console).readInt("Row: ");
        verify(this.console).readInt("Column: ");
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewCoordinatesWhenRow0AndColumn0ThenAssertionException() {
        when(this.console.readInt("Row: ")).thenReturn(0);
        when(this.console.readInt("Column: ")).thenReturn(0);
        this.coordinateView.read("Title");
        verify(this.console).readInt("Row: ");
        verify(this.console).readInt("Column: ");
    }

    @Test
    public void testGivenNewCoordinatesWhenRow1AndColumn1ThenIsCorrect() {
        when(this.console.readInt("Row: ")).thenReturn(1);
        when(this.console.readInt("Column: ")).thenReturn(1);
        this.coordinateView.read("Title");
        verify(this.console).readInt("Row: ");
        verify(this.console).readInt("Column: ");
    }

    @Test
    public void testGivenNewCoordinatesWhenRow3AndColumn3ThenIsCorrect() {
        when(this.console.readInt("Row: ")).thenReturn(3);
        when(this.console.readInt("Column: ")).thenReturn(3);
        this.coordinateView.read("Title");
        verify(this.console).readInt("Row: ");
        verify(this.console).readInt("Column: ");
    }
}