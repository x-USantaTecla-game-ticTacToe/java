package usantatecla.tictactoe.models.Files;

import java.io.BufferedReader;
import java.io.FileWriter;

interface FileDAO {

	void save (FileWriter fileWriter);
	
	void load (BufferedReader bufferedReader);
	
}
