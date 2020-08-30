package usantatecla.tictactoe.models.DAO;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import usantatecla.tictactoe.models.Board;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Turn;

class BoardDAO implements DAO {

    private Board board;

    BoardDAO(Board board) {
		this.board = board;
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
					if ("-".equals(tokenCoordinate)) {
                        this.board.setCoordinate(i, j, null);
					} else {
                        String[] coordinatesString = tokenCoordinate.split("\\.");
                        this.board.setCoordinate(i, j, new Coordinate(Integer.parseInt(coordinatesString[0]),
                        Integer.parseInt(coordinatesString[1])));
					}
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
}