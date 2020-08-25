package usantatecla.tictactoe.models.DAO;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import usantatecla.tictactoe.models.Turn;

class TurnDAO implements DAO {

    private Turn turn;

    TurnDAO(Turn turn) {
		this.turn = turn;
    }
    
    public void save(FileWriter fileWriter) {
		try {
			fileWriter.write(this.turn.getValue() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void load(BufferedReader bufferedReader) {
		try {
			this.turn.setValue(Integer.parseInt(bufferedReader.readLine()));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
}