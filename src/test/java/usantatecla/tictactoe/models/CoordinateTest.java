package usantatecla.tictactoe.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import usantatecla.tictactoe.types.Error;
import usantatecla.utils.Direction;

public class CoordinateTest {

    private Coordinate coordinate;

    public CoordinateTest() {
        this.coordinate = new Coordinate(1, 1);
    }
    
    @Test
    public void testGivenNewCoordinatesWhenGetDirectionThenNotExist() {
        assertEquals(Direction.NULL, new Coordinate(0, 1).getDirection(new Coordinate(1, 0)));
    }

    @Test
    public void testGivenNewCoordinatesWhenGetDirectionThenExist() {
        assertEquals(Direction.HORIZONTAL, this.coordinate.getDirection(new Coordinate(1, 0)));
        assertEquals(Direction.VERTICAL, this.coordinate.getDirection(new Coordinate(2, 1)));
        assertEquals(Direction.MAIN_DIAGONAL, this.coordinate.getDirection(new Coordinate(2, 2)));
        assertEquals(Direction.INVERSE_DIAGONAL, this.coordinate.getDirection(new Coordinate(0, 2)));
    }


    @Test
    public void testGivenNewCoordinatesWhenIsValidThenTrue() {
        assertEquals(Error.NULL, new Coordinate(0, 0).isValid());
        assertEquals(Error.NULL, new Coordinate(2, 2).isValid());
    }

    @Test
    public void testGivenNewCoordinatesWhenIsValidThenFalse() {
        assertEquals(Error.NOT_VALID, new Coordinate(-1, 0).isValid());
        assertEquals(Error.NOT_VALID, new Coordinate(2, 3).isValid());
    }

}
