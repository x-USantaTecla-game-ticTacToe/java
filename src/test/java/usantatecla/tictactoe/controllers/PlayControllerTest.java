package usantatecla.tictactoe.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.types.Error;

public class PlayControllerTest {
    
    private PlayController playController;
    private Session session;

    public PlayControllerTest() {
        this.session = new Session();
        this.session.setUsers(0);
        this.session.next();
        this.playController = new PlayController(this.session);
    }

    @Test
    public void test() {
        Coordinate coordinate = new Coordinate(0,0);
        assertEquals(Error.NULL, this.playController.put(coordinate));
    }

}