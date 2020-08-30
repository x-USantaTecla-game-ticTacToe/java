package usantatecla.tictactoe.models.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import usantatecla.tictactoe.models.SessionImplementation;
import usantatecla.tictactoe.types.StateValue;

public class SessionImplementationDAO {

    public static final String EXTENSION = ".mm";

	public static final String DIRECTORY = "./partidas";

	private static File directory;

	static {
		SessionImplementationDAO.directory = new File(SessionImplementationDAO.DIRECTORY);
	}

    private SessionImplementation sessionImplementation;

	private GameDAO gameDAO;
	
	public void associate(SessionImplementation sessionImplementation) {
		this.sessionImplementation = sessionImplementation;
		this.gameDAO = new GameDAO(this.sessionImplementation.getGame());
	}

    public void load(String name) {
		this.sessionImplementation.setName(name);
		File file = new File(SessionImplementationDAO.directory, name);
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			this.gameDAO.load(bufferedReader);
			this.sessionImplementation.resetRegistry();
			this.sessionImplementation.registry();
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
        }
        this.sessionImplementation.setValueState(StateValue.IN_GAME);
		if (this.sessionImplementation.isTicTacToe()) {
            this.sessionImplementation.setValueState(StateValue.RESUME);
		}
	}

	public void save() {
		this.save(this.sessionImplementation.getName());
	}

	public void save(String name) {
		if (name.endsWith(SessionImplementationDAO.EXTENSION)) {
			name = name.replace(SessionImplementationDAO.EXTENSION, "");
		}
		File file = new File(SessionImplementationDAO.directory, name + SessionImplementationDAO.EXTENSION);
		try {
			FileWriter fileWriter = new FileWriter(file);
			this.gameDAO.save(fileWriter);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String[] getGamesNames() {
		return SessionImplementationDAO.directory.list();
	}

	public boolean exists(String name) {
		for (String auxName : this.getGamesNames()) {
			if (auxName.equals(name + SessionImplementationDAO.EXTENSION)) {
				return true;
			}
		}
		return false;
	}
    
}