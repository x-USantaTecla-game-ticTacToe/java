package usantatecla.tictactoe.models.dataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Player;
import usantatecla.tictactoe.models.DAO.GameDAO;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.types.Token;

public class GameDBDAO extends GameDAO implements DBDAO {

	private BoardDBDAO boardDBDAO;

	protected GameDBDAO(Game game) {
		super(game);
		this.boardDBDAO = new BoardDBDAO(this.game.getBoard());
	}

	public void save(String name, Connection connection, boolean exists) {
		if (exists) {
			String sql = "UPDATE Games SET " 
					+ "playerType1 = " + this.game.getPlayerOrdinalTypeByIndex(0) + ", "
					+ "playerToken1 = " + this.game.getPlayerOrdinalTokenByIndex(0) + ", "
					+ "playerType2 = " + this.game.getPlayerOrdinalTypeByIndex(1) + ", "
					+ "playerToken2 = " + this.game.getPlayerOrdinalTokenByIndex(1) + ", "
					+ "turn = " + this.game.getTurn().getValue() 
					+ " WHERE name = '" + name + "';";
			try {
				Statement statement = connection.createStatement();
				statement.executeUpdate(sql);
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			String sql = "INSERT INTO Games VALUES ('" + name + "',"
					+ this.game.getPlayerOrdinalTypeByIndex(0) + ","
					+ this.game.getPlayerOrdinalTokenByIndex(0) + ","
					+ this.game.getPlayerOrdinalTypeByIndex(1) + ","
					+ this.game.getPlayerOrdinalTokenByIndex(1) + ","
					+ this.game.getTurn().getValue() + ");";
			try {
				Statement statement = connection.createStatement();
				statement.executeUpdate(sql);
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		this.boardDBDAO.save(name, connection, exists);
	}

	
	public void load(String name, Connection connection) {
		this.boardDBDAO.load(name, connection);
		String sql = "SELECT * FROM Games WHERE name = '" + name + "';";
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			if (result.next()) {
				int typeFirstPlayer = result.getInt("playerType1");
				int tokenFirstPlayer = result.getInt("playerToken1");
				this.game.setPlayerByIndex(new Player(Token.values()[tokenFirstPlayer], this.game.getBoard(),
				PlayerType.values()[typeFirstPlayer]), 0);
				int typeSecondPlayer = result.getInt("playerType2");
				int tokenSecondPlayer = result.getInt("playerToken2");
				this.game.setPlayerByIndex(new Player(Token.values()[tokenSecondPlayer], this.game.getBoard(),
				PlayerType.values()[typeSecondPlayer]), 1);
				this.game.setTurnWithValue(result.getInt("turn"));
			}
			result.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
