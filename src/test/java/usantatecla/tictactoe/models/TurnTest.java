package usantatecla.tictactoe.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TurnTest {

    private Turn turn;
    private Player[] players;

    public TurnTest() {
        this.turn = new Turn(new Board(2));
        this.turn.setUsers(2);
    }

    @Test
    public void testGivenNewTurnWhenChangeTurnThenIsOtherTurn() {
        assertEquals(this.players[0].getToken(), this.turn.getPlayer().getToken());
        assertEquals(this.players[1].getToken(), this.turn.getOtherPlayer().getToken());
        this.turn.change();
        assertEquals(this.players[1].getToken(), this.turn.getPlayer().getToken());
        assertEquals(this.players[0].getToken(), this.turn.getOtherPlayer().getToken());
    }

    @Test
    public void testGivenNewTurnWhenChangeTurnTwoTimesThenIsTheSameTurn() {
        assertEquals(this.players[0].getToken(), this.turn.getPlayer().getToken());
        assertEquals(this.players[1].getToken(), this.turn.getOtherPlayer().getToken());
        this.turn.change();
        assertEquals(this.players[1].getToken(), this.turn.getPlayer().getToken());
        assertEquals(this.players[0].getToken(), this.turn.getOtherPlayer().getToken());
        this.turn.change();
        assertEquals(this.players[0].getToken(), this.turn.getPlayer().getToken());
        assertEquals(this.players[1].getToken(), this.turn.getOtherPlayer().getToken());
    }
}
