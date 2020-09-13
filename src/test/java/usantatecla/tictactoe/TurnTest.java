package usantatecla.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TurnTest {

    private Turn turn;
    private Player[] players;

    public TurnTest() {
    	final int NUMBER_PLAYER = 2;
        Board board = new Board(NUMBER_PLAYER);
        this.turn = new Turn(board);
    }

//    @Test
//    public void testGivenNewTurnWhenChangeTurnThenIsOtherTurn() {
//        assertEquals(this.players[0].getToken(), this.turn.getPlayer().getToken());
//        assertEquals(this.players[1].getToken(), this.turn.getOtherPlayer().getToken());
//        this.turn.change();
//        assertEquals(this.players[1].getToken(), this.turn.getPlayer().getToken());
//        assertEquals(this.players[0].getToken(), this.turn.getOtherPlayer().getToken());
//    }
//
//    @Test
//    public void testGivenNewTurnWhenChangeTurnTwoTimesThenIsTheSameTurn() {
//        assertEquals(this.players[0].getToken(), this.turn.getPlayer().getToken());
//        assertEquals(this.players[1].getToken(), this.turn.getOtherPlayer().getToken());
//        this.turn.change();
//        assertEquals(this.players[1].getToken(), this.turn.getPlayer().getToken());
//        assertEquals(this.players[0].getToken(), this.turn.getOtherPlayer().getToken());
//        this.turn.change();
//        assertEquals(this.players[0].getToken(), this.turn.getPlayer().getToken());
//        assertEquals(this.players[1].getToken(), this.turn.getOtherPlayer().getToken());
//    }
}
