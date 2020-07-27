package usantatecla.tictactoe.views;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.utils.Console;

@RunWith(MockitoJUnitRunner.class)
public class CoordinateViewTest {
    static final String ENTER_COORDINATE_TO_PUT = "Enter a coordinate to put a token:";

    @Mock
    Console console;

    @InjectMocks
    CoordinateView coordinateView;

    @Test
    public void testGivenNewCoordinateViewThenReadCoordinateAndIsCorrect() {
        when(this.console.readInt("Row: ")).thenReturn(1);
        when(this.console.readInt("Column: ")).thenReturn(1);
        Coordinate coordinateRead = this.coordinateView.read(ENTER_COORDINATE_TO_PUT);
        Coordinate coordinateExpected = new Coordinate(0, 0);
        assertEquals(coordinateExpected.getRow(), coordinateRead.getRow());
        assertEquals(coordinateExpected.getColumn(), coordinateRead.getColumn());
    }
}