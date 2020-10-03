package usantatecla.tictactoe.models;

public class Game {
    
    private Board board;

	private Player[] players;

    private Turn turn;
    
    public Game() {
        this.newGame();
    }

    public void createPlayers(int numberOfUsers) {
		for (int i = 0; i < numberOfUsers; i++) {
			this.players[i] = new Player(Token.values()[i], this.board, PlayerType.USER_PLAYER);
		}
		for (int i = numberOfUsers; i < Turn.NUM_PLAYERS; i++) {
			this.players[i] = new Player(Token.values()[i], this.board, PlayerType.MACHINE_PLAYER);
		}
    }

    public Board getBoard() {
        return this.board;
    }

    public boolean isUser(){
        return this.getTokenPlayerFromTurn().getType() == PlayerType.USER_PLAYER;
    }

    public boolean isBoardComplete() {
        return this.board.isCompleted();
    }

    public void put(Coordinate coordinate) {
        this.turn.getPlayer().put(coordinate);
    }

    public void move(Coordinate[] coordinates) {
        this.turn.getPlayer().move(coordinates);
    }

    public Player getTokenPlayerFromTurn() {
        return this.turn.getPlayer();
    }

    public void changeTurn() {
        this.turn.change();
    }

    public boolean isTicTacToe() {
        return this.board.isTicTacToe(this.turn.getPlayer().getToken());
    }

    public int getValueFromTurn() {
        return this.turn.getValue();
    }

    public void newGame() {
		this.board = new Board();
        this.players = new Player[Turn.NUM_PLAYERS];
        this.turn = new Turn(this.players);
	}
}