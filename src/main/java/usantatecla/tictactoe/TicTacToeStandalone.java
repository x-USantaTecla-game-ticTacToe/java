package usantatecla.tictactoe;

import java.util.HashMap;
import java.util.Map;

import usantatecla.tictactoe.controllers.implementation.LogicImplementation;
import usantatecla.tictactoe.models.DAO.SessionImplementationDAO;
import usantatecla.tictactoe.models.Files.SessionImplementationFileDAO;
import usantatecla.tictactoe.models.dataBase.SessionImplementationDBDAO;

public class TicTacToeStandalone extends TicTacToe {

	private Map<String, SessionImplementationDAO> sessionDaoMap;

	public TicTacToeStandalone() {
		super();
		this.sessionDaoMap = new HashMap<String, SessionImplementationDAO>();
		this.sessionDaoMap.put("file", new SessionImplementationFileDAO());
		this.sessionDaoMap.put("db", new SessionImplementationDBDAO());
	}

    public void play(String arg) {
		SessionImplementationDAO sessionImplementationDAO = this.sessionDaoMap.get(arg);
		if (sessionImplementationDAO == null) {
			System.out.println("Introduce 'file' para ficheros o 'db' para bases de datos");
			System.exit(0);
		}
		this.logic = new LogicImplementation(sessionImplementationDAO);
		super.play();
	}
	
	public static void main(String[] args) {
		new TicTacToeStandalone().play(args[0]);
	}
    
}