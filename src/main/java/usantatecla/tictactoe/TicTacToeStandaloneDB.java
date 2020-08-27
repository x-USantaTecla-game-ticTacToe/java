package usantatecla.tictactoe;

import usantatecla.tictactoe.models.DAO.SessionImplementationDAO;
import usantatecla.tictactoe.models.dataBase.SessionImplementationDBDAO;

public class TicTacToeStandaloneDB extends TicTacToeStandalone {

    protected SessionImplementationDAO createDAO() {
		return new SessionImplementationDBDAO();
	}
	
	public static void main(String[] args) {
		new TicTacToeStandaloneDB().play();
	}
    
}