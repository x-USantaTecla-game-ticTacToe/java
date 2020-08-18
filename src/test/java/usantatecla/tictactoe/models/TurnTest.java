package usantatecla.tictactoe.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.types.Token;

public class TurnTest {

    private Turn turn;
    private Player[] players;

    public TurnTest() {
        Board board = new Board();
        this.players = new Player[2];
        this.players[0] = new Player(Token.values()[0], board, PlayerType.USER_PLAYER);
        this.players[1] = new Player(Token.values()[1], board, PlayerType.MACHINE_PLAYER);
        this.turn = new Turn(this.players);
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
