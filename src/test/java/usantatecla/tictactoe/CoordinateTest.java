package usantatecla.tictactoe;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import usantatecla.utils.Console;
import usantatecla.utils.Direction;

@RunWith(MockitoJUnitRunner.class)
public class CoordinateTest {

    private Coordinate coordinate11;
    private Coordinate coordinate12;
    private Coordinate coordinate22;
    private Coordinate coordinate13;
    private Coordinate coordinate23;

    @Mock
    private Console console;

    @InjectMocks
    private Coordinate coordinate = new Coordinate();

    public CoordinateTest() {
        this.coordinate11 = new Coordinate(1, 1);
        this.coordinate12 = new Coordinate(1, 2);
        this.coordinate22 = new Coordinate(2, 2);
        this.coordinate13 = new Coordinate(1, 3);
        this.coordinate23 = new Coordinate(2, 3);
    }

    @Test
    public void testGivenNewCoordinatesWhenCompareCoordinates11And12ThenIsHorizontal() {
        assertEquals(Direction.HORIZONTAL, this.coordinate11.getDirection(this.coordinate12));
    }

    @Test
    public void testGivenNewCoordinatesWhenCompareCoordinates12And22ThenIsVertical() {
        assertEquals(Direction.VERTICAL, this.coordinate12.getDirection(this.coordinate22));
    }

    @Test
    public void testGivenNewCoordinatesWhenCompareCoordinates11And22ThenIsMainDiagonal() {
        assertEquals(Direction.MAIN_DIAGONAL, this.coordinate11.getDirection(this.coordinate22));
    }

    @Test
    public void testGivenNewCoordinatesWhenCompareCoordinates13And22ThenIsInverseDiagonal() {
        assertEquals(Direction.INVERSE_DIAGONAL, this.coordinate13.getDirection(this.coordinate22));
    }

    @Test
    public void testGivenNewCoordinatesWhenCompareCoordinates11And23ThenDirectionIsNull() {
        assertEquals(null, this.coordinate11.getDirection(this.coordinate23));
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewCoordinatesWhenRow4AndColumn4ThenAssertionException() {
        when(this.console.readInt("Row: ")).thenReturn(4);
        when(this.console.readInt("Column: ")).thenReturn(4);
        this.coordinate.read("Title");
        verify(this.console).readInt("Row: ");
        verify(this.console).readInt("Column: ");
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewCoordinatesWhenRow0AndColumn0ThenAssertionException() {
        when(this.console.readInt("Row: ")).thenReturn(0);
        when(this.console.readInt("Column: ")).thenReturn(0);
        this.coordinate.read("Title");
        verify(this.console).readInt("Row: ");
        verify(this.console).readInt("Column: ");
    }

    @Test
    public void testGivenNewCoordinatesWhenRow1AndColumn1ThenIsCorrect() {
        when(this.console.readInt("Row: ")).thenReturn(1);
        when(this.console.readInt("Column: ")).thenReturn(1);
        this.coordinate.read("Title");
        verify(this.console).readInt("Row: ");
        verify(this.console).readInt("Column: ");
    }

    @Test
    public void testGivenNewCoordinatesWhenRow3AndColumn3ThenIsCorrect() {
        when(this.console.readInt("Row: ")).thenReturn(3);
        when(this.console.readInt("Column: ")).thenReturn(3);
        this.coordinate.read("Title");
        verify(this.console).readInt("Row: ");
        verify(this.console).readInt("Column: ");
    }
}
