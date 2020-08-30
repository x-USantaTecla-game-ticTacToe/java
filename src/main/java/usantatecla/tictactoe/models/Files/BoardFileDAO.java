package usantatecla.tictactoe.models.Files;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import usantatecla.tictactoe.models.Board;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Turn;
import usantatecla.tictactoe.models.DAO.BoardDAO;

class BoardFileDAO extends BoardDAO implements FileDAO {

    BoardFileDAO(Board board) {
		super(board);
	}

    public void save(FileWriter fileWriter) {
		try {
			for (Coordinate[] coordinatesPlayer : this.board.getCoordinates()) {
				for (Coordinate coordinate : coordinatesPlayer) {
					if (coordinate == null) {
						fileWriter.write(Board.EMPTY + "\n");
					} else {
						fileWriter.write(coordinate.getRow() + "." + coordinate.getColumn() + "\n");
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load(BufferedReader bufferedReader) {
		try {
			for (int i = 0; i < Turn.NUM_PLAYERS; i++) {
				for (int j = 0; j < Coordinate.DIMENSION; j++) {
					String tokenCoordinate = bufferedReader.readLine();
					this.loadCoordinateInBoard(tokenCoordinate, i, j);
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
}