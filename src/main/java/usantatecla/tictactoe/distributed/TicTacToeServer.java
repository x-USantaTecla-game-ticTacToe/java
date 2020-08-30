package usantatecla.tictactoe.distributed;

import java.util.HashMap;
import java.util.Map;

import usantatecla.tictactoe.distributed.dispatchers.DispatcherPrototype;
import usantatecla.tictactoe.models.DAO.SessionImplementationDAO;
import usantatecla.tictactoe.models.Files.SessionImplementationFileDAO;
import usantatecla.tictactoe.models.dataBase.SessionImplementationDBDAO;

public class TicTacToeServer {

	private Map<String, SessionImplementationDAO> sessionDaoMap;

	private LogicImplementationServer logic;

	private DispatcherPrototype dispatcherPrototype;

	protected TicTacToeServer() {
		this.sessionDaoMap = new HashMap<String, SessionImplementationDAO>();
		this.sessionDaoMap.put("file", new SessionImplementationFileDAO());
		this.sessionDaoMap.put("db", new SessionImplementationDBDAO());
		this.dispatcherPrototype = new DispatcherPrototype();
	}

	protected void serve() {
		this.dispatcherPrototype.serve();
	}

	public void play(String arg) {
		SessionImplementationDAO sessionImplementationDAO = this.sessionDaoMap.get(arg);
		if (sessionImplementationDAO == null) {
			System.out.println("Introduce 'file' para ficheros o 'db' para bases de datos");
			System.exit(0);
		}
		this.logic = new LogicImplementationServer(sessionImplementationDAO);
		this.logic.createDispatchers(this.dispatcherPrototype);
		this.serve();
	}

	public static void main(String[] args) {
		new TicTacToeServer().play("file");
	}

}
