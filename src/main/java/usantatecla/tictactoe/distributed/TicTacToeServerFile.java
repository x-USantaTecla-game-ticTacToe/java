package usantatecla.tictactoe.distributed;

import usantatecla.tictactoe.models.DAO.SessionImplementationDAO;
import usantatecla.tictactoe.models.Files.SessionImplementationFileDAO;

public class TicTacToeServerFile extends TicTacToeServer{
	
	@Override
	protected SessionImplementationDAO createDAO() {
		return new SessionImplementationFileDAO();
	}

	public static void main(String[] args) {
		new TicTacToeServerFile().serve();
	}

}
