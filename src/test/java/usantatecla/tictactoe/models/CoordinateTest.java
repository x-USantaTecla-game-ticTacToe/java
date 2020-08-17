package usantatecla.tictactoe.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import usantatecla.utils.Console;
import usantatecla.utils.Direction;

public class CoordinateTest {

    private Coordinate coordinate11;
    private Coordinate coordinate12;
    private Coordinate coordinate22;
    private Coordinate coordinate13;
    private Coordinate coordinate23;

    @Mock
    Console console;

    @InjectMocks
    Coordinate coordinate = new Coordinate();

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
}
