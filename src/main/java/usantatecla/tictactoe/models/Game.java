package usantatecla.tictactoe.models;

public class Game {
    
    private Board board;

	private Player[] players;

    private Turn turn;
    
    public Game() {
        this.board = new Board();
        this.players = new Player[Turn.PLAYERS];
        this.turn = new Turn(this.players);
    }

    public void createPlayers(int numberOfUsers) {
		for (int i = 0; i < numberOfUsers; i++) {
			this.players[i] = new UserPlayer(Token.values()[i], this.board);
		}
		for (int i = numberOfUsers; i < Turn.PLAYERS; i++) {
			this.players[i] = new MachinePlayer(Token.values()[i], this.board);
		}
    }

    public Board getBoard() {
        return this.board;
    }

    public boolean isBoardComplete() {
        return this.board.isCompleted();
    }

    public void putTokenPlayerFromTurn() {
        this.turn.getPlayer().put();
    }

    public void moveTokenPlayerFromTurn() {
        this.turn.getPlayer().move();
    }

    public void changeTurn() {
        this.turn.change();
    }

    public boolean isTicTacToe() {
        return this.board.isTicTacToe(this.turn.getOtherPlayer().getToken());
    }

    public int getOtherValueFromTurn() {
        return this.turn.getOtherValue();
    }
}