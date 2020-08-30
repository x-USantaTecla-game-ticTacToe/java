package usantatecla.tictactoe.models.Files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import usantatecla.tictactoe.models.SessionImplementation;
import usantatecla.tictactoe.models.DAO.SessionImplementationDAO;
import usantatecla.tictactoe.types.StateValue;

public class SessionImplementationFileDAO extends SessionImplementationDAO {

    public static final String EXTENSION = ".mm";

	public static final String DIRECTORY = "./partidas";

	private static File directory;

	static {
		SessionImplementationFileDAO.directory = new File(SessionImplementationFileDAO.DIRECTORY);
	}

	private GameFileDAO gameDAO;
	
	public void associate(SessionImplementation sessionImplementation) {
		super.associate(sessionImplementation);
		this.gameDAO = new GameFileDAO(this.sessionImplementation.getGame());
	}

    public void load(String name) {
		this.sessionImplementation.setName(name);
		File file = new File(SessionImplementationFileDAO.directory, name);
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
		if (name.endsWith(SessionImplementationFileDAO.EXTENSION)) {
			name = name.replace(SessionImplementationFileDAO.EXTENSION, "");
		}
		File file = new File(SessionImplementationFileDAO.directory, name + SessionImplementationFileDAO.EXTENSION);
		try {
			FileWriter fileWriter = new FileWriter(file);
			this.gameDAO.save(fileWriter);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String[] getGamesNames() {
		return SessionImplementationFileDAO.directory.list();
	}

	public boolean exists(String name) {
		for (String auxName : this.getGamesNames()) {
			if (auxName.equals(name + SessionImplementationFileDAO.EXTENSION)) {
				return true;
			}
		}
		return false;
	}
    
}