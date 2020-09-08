package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.types.Token;

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

    Memento createMemento() {
        Board board = this.board.copy();
        return new Memento(board, this.createCopyOfPlayers(this.players, board), this.turn);
    }

    void set(Memento memento) {
        this.board = memento.getBoard().copy();
        this.players = this.createCopyOfPlayers(memento.getPlayers(), this.board);
        this.turn = memento.getTurn().copy(this.players);
    }

    private Player[] createCopyOfPlayers(Player[] players, Board board) {
        Player[] playersCopy = new Player[2];
        for (int i = 0; i < Turn.NUM_PLAYERS; i++) {
            playersCopy[i] = new Player(players[i].getToken(), board, players[i].getType());
        }
        return playersCopy;
    }

    public boolean isBoardComplete() {
        return this.board.isCompleted();
    }

    public Error putTokenPlayerFromTurn(Coordinate coordinate) {
        Error error = this.getPutCoordinateError(coordinate);
        assert error == null;
        if (error != null) {
            return error;
        }
        this.turn.getPlayer().put(coordinate);
        this.changeTurn();
        return null;
    }

    public Error moveTokenPlayerFromTurn(Coordinate[] coordinates) {
        Error error = this.getMoveOriginCoordinateError(coordinates[0]);
        assert error == null;
        if (error != null) {
            return error;
        }
        error = this.getMoveTargetCoordinateError(coordinates[0], coordinates[1]);
        assert error == null;
        if (error != null) {
            return error;
        }
        this.turn.getPlayer().move(coordinates);
        this.changeTurn();
        return null;
    }

    public PlayerType getTypeOfTokenPlayerFromTurn() {
        return this.turn.getPlayer().getType();
    }

    public Error getPutCoordinateError(Coordinate coordinate) {
        if (!board.isEmpty(coordinate)) {
			return Error.NOT_OWNER;
		}
		return null;
    }

    public Error getMoveOriginCoordinateError(Coordinate originCoordinate) {
        if (!board.isOccupied(originCoordinate, this.turn.getPlayer().getToken())) {
			return Error.NOT_OWNER;
		}
		return null;
    }

    public Error getMoveTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
        if (originCoordinate.equals(targetCoordinate)) {
			return Error.SAME_COORDINATES;
		} else if (!board.isEmpty(targetCoordinate)) {
			return Error.NOT_EMPTY;
		}
		return null;
    }

    public Token getToken(Coordinate coordinate) {
        return this.board.getToken(coordinate);
    }

    public void changeTurn() {
        this.turn.change();
    }

    public boolean isTicTacToe() {
        return this.board.isTicTacToe(this.turn.getOtherPlayer().getToken());
    }

    public int getValueFromTurn() {
        return this.turn.getValue();
    }

    public int getCoordinateDimension() {
        return Coordinate.DIMENSION;
    }

    public boolean isEmptyToken(Coordinate coordinate) {
        return this.getToken(coordinate) == null;
    }

    public char getTokenChar(Coordinate coordinate) {
        return this.getToken(coordinate).getChar();
    }

    public void newGame() {
		this.board = new Board();
        this.players = new Player[Turn.NUM_PLAYERS];
        this.turn = new Turn(this.players);
	}
}