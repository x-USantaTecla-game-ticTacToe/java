package usantatecla.tictactoe.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import usantatecla.tictactoe.types.Direction;

public class CoordinateTest {

    private Coordinate coordinate11;
    private Coordinate coordinate12;
    private Coordinate coordinate22;
    private Coordinate coordinate13;
    private Coordinate coordinate23;

    public CoordinateTest() {
        this.coordinate11 = new Coordinate(1, 1);
        this.coordinate12 = new Coordinate(1, 2);
        this.coordinate22 = new Coordinate(2, 2);
        this.coordinate13 = new Coordinate(1, 3);
        this.coordinate23 = new Coordinate(2, 3);
    }

    @Test
    public void testGivenNewCoordinatesThenIsHorizontal() {
        assertEquals(Direction.HORIZONTAL, this.coordinate11.getDirection(this.coordinate12));
    }

    @Test
    public void testGivenNewCoordinatesThenIsVertical() {
        assertEquals(Direction.VERTICAL, this.coordinate12.getDirection(this.coordinate22));
    }

    @Test
    public void testGivenNewCoordinatesThenIsMainDiagonal() {
        assertEquals(Direction.MAIN_DIAGONAL, this.coordinate11.getDirection(this.coordinate22));
    }

    @Test
    public void testGivenNewCoordinatesThenIsInverseDiagonal() {
        assertEquals(Direction.INVERSE_DIAGONAL, this.coordinate13.getDirection(this.coordinate22));
    }

    @Test
    public void testGivenNewCoordinatesThenDirectionIsNull() {
        assertEquals(null, this.coordinate11.getDirection(this.coordinate23));
    }
}
