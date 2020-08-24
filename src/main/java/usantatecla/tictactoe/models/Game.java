package usantatecla.tictactoe.models;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.types.Token;

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
            this.players[i] = new Player(Token.values()[i], this.board, PlayerType.USER_PLAYER);
        }
        for (int i = numberOfUsers; i < Turn.PLAYERS; i++) {
            this.players[i] = new Player(Token.values()[i], this.board, PlayerType.MACHINE_PLAYER);
        }
    }

    Memento createMemento() {
        Board board = this.board.copy();
        return new Memento(board, this.createCopyOfPlayers(this.players, board), turn);
    }

    void set(Memento memento) {
        this.board = memento.getBoard().copy();
        this.players = this.createCopyOfPlayers(memento.getPlayers(), this.board);
        this.turn = memento.getTurn().copy(this.players);
    }

    private Player[] createCopyOfPlayers(Player[] players, Board board) {
        Player[] playersCopy = new Player[2];
        for (int i = 0; i < Turn.PLAYERS; i++) {
            playersCopy[i] = new Player(players[i].getToken(), board, players[i].getType());
        }
        return playersCopy;
    }

    public boolean isBoardComplete() {
        return this.board.isCompleted();
    }

    public void putTokenPlayerFromTurn(Coordinate coordinate) {
        this.turn.getPlayer().put(coordinate);
    }

    public void moveTokenPlayerFromTurn(Coordinate[] coordinates) {
        this.turn.getPlayer().move(coordinates);
    }

    public PlayerType getTypeOfTokenPlayerFromTurn() {
        return this.turn.getPlayer().getType();
    }

    public Error getErrorsPutCoordinate(Coordinate coordinate) {
        if (!board.isEmpty(coordinate)) {
            return Error.NOT_OWNER;
        }
        return null;
    }

    public Error getErrorsMoveOriginCoordinate(Coordinate originCoordinate) {
        if (!board.isOccupied(originCoordinate, this.turn.getPlayer().getToken())) {
            return Error.NOT_OWNER;
        }
        return null;
    }

    public Error getErrorsMoveTargetCoordinate(Coordinate originCoordinate, Coordinate targetCoordinate) {
        if (originCoordinate.equals(targetCoordinate)) {
            return Error.SAME_COORDINATES;
        } else if (!board.isEmpty(targetCoordinate)) {
            return Error.NOT_EMPTY;
        }
        return null;
    }

    public Token getToken(int row, int column) {
        return this.board.getToken(new Coordinate(row, column));
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

    void save(FileWriter fileWriter) {
        try {
            this.board.save(fileWriter);
            fileWriter.write(this.players[0].getType().ordinal() + "\n");
            fileWriter.write(this.players[0].getToken().ordinal() + "\n");
            fileWriter.write(this.players[1].getType().ordinal() + "\n");
            fileWriter.write(this.players[1].getToken().ordinal() + "\n");
            this.turn.save(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void load(BufferedReader bufferedReader) {
        try {
            this.board.load(bufferedReader);
            int typeFirstPlayer = Integer.parseInt(bufferedReader.readLine());
            int tokenFirstPlayer = Integer.parseInt(bufferedReader.readLine());
            this.players[0] = new Player(Token.values()[tokenFirstPlayer], this.board,
                    PlayerType.values()[typeFirstPlayer]);
            int typeSecondPlayer = Integer.parseInt(bufferedReader.readLine());
            int tokenSecondPlayer = Integer.parseInt(bufferedReader.readLine());
            this.players[1] = new Player(Token.values()[tokenSecondPlayer], this.board,
                    PlayerType.values()[typeSecondPlayer]);
            this.turn.load(bufferedReader);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}