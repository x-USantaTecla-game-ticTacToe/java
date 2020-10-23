package usantatecla.tictactoe.models;

class Memento {

  private Board board;
  private Turn turn;

  Memento(Board board, Player[] players, Turn turn) {
    this.board = board.copy();
    this.turn = turn.copy();
  }

  Board getBoard() {
    return this.board;
  }

  Turn getTurn() {
    return this.turn;
  }

}
