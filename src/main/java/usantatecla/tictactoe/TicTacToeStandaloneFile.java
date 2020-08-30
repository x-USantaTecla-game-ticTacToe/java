package usantatecla.tictactoe;

import usantatecla.tictactoe.models.DAO.SessionImplementationDAO;
import usantatecla.tictactoe.models.Files.SessionImplementationFileDAO;

public class TicTacToeStandaloneFile extends TicTacToeStandalone {

    @Override
	protected SessionImplementationDAO createDAO() {
		return new SessionImplementationFileDAO();
	}
	
	public static void main(String[] args) {
		new TicTacToeStandaloneFile().play();
	}
    
}