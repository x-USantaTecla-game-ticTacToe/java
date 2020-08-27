package usantatecla.tictactoe.distributed;

import usantatecla.tictactoe.models.DAO.SessionImplementationDAO;
import usantatecla.tictactoe.models.dataBase.SessionImplementationDBDAO;

public class TicTacToeServerDB extends TicTacToeServer {
	
	@Override
	protected SessionImplementationDAO createDAO() {
		return new SessionImplementationDBDAO();
	}

	public static void main(String[] args) {
		new TicTacToeServerDB().serve();
	}

}
