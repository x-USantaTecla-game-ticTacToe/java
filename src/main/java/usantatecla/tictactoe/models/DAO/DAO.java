package usantatecla.tictactoe.models.DAO;

import java.io.BufferedReader;
import java.io.FileWriter;

interface DAO {

	void save (FileWriter fileWriter);
	
	void load (BufferedReader bufferedReader);
	
}
