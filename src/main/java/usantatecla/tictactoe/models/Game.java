package usantatecla.tictactoe.models;

public class Game {
    
    private Board board;
    private Turn turn;
    
    public Game() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public void setUsers(int users) {
		this.turn.setUsers(users);
    }

    public boolean isBoardComplete() {
        return this.board.isCompleted();
    }

    public boolean isUser() {
		return this.turn.isUser();
	}

    public Error put(Coordinate coordinate) {
        return this.turn.put(coordinate);
    }

    public Error move(Coordinate origin, Coordinate target) {
        return this.turn.move(origin, target);
    }

    public void next() {
        this.turn.next();
    }

    public boolean isTicTacToe() {
        return this.board.isTicTacToe(this.turn.getToken());
    }

	public Token getToken(Coordinate coordinate) {
		return this.board.getToken(coordinate);
    }
    
    public Token getToken() {
		return this.turn.getToken();
	}

	public int getMaxPlayers() {
		return Turn.NUMBER_PLAYERS;
	}

	public void reset() {
        this.board.reset();
	}

}