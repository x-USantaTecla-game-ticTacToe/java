package usantatecla.tictactoe.models.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import usantatecla.tictactoe.models.SessionImplementation;
import usantatecla.tictactoe.models.DAO.SessionImplementationDAO;
import usantatecla.tictactoe.types.StateValue;

public class SessionImplementationDBDAO extends SessionImplementationDAO {

	private static final String URL = "jdbc:mysql://localhost:3306?serverTimezone=UTC";

	private static final String USER = "root";

	private static final String PASSWORD = "root";

	private GameDBDAO gameDBDAO;

	protected Connection connection;

	public void associate(SessionImplementation sessionImplementation) {
		super.associate(sessionImplementation);
		this.gameDBDAO = new GameDBDAO(this.sessionImplementation.getGame());
	}

	public SessionImplementationDBDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			this.connection = DriverManager.getConnection(SessionImplementationDBDAO.URL,
					SessionImplementationDBDAO.USER, SessionImplementationDBDAO.PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			Statement statement = this.connection.createStatement();
			String sql = "CREATE DATABASE IF NOT EXISTS TicTacToe;\n";
			statement.executeUpdate(sql);
			sql = "USE TicTacToe;";
			statement.executeUpdate(sql);
			sql = "CREATE TABLE IF NOT EXISTS `Games`\n" + "	(`name` varchar(20) NOT NULL,\n"
					+ "	`playerType1`int(1),\n" + "	`playerToken1`int(1),\n"
					+ "	`playerType2`int(1),\n" + "	`playerToken2`int(1),\n"
					+ "	`turn`int(1),\n" 
					+ "	PRIMARY KEY (`name`));";
			statement.executeUpdate(sql);
			sql = "CREATE TABLE IF NOT EXISTS `Boards`\n" + "	(`name` varchar(20) NOT NULL,\n"
					+ "	`player1Coordinate1`varchar(3) NOT NULL,\n" + "	`player1Coordinate2`varchar(3) NOT NULL,\n" 
					+ "	`player1Coordinate3`varchar(3) NOT NULL,\n" + "	`player2Coordinate1`varchar(3) NOT NULL,\n"
					+ "	`player2Coordinate2`varchar(3) NOT NULL,\n" + "	`player2Coordinate3`varchar(3) NOT NULL,\n"
					+ "	FOREIGN KEY (`name`) REFERENCES `Games` (`name`),\n"
					+ "	PRIMARY KEY (`name`));";
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void load(String name) {
		this.sessionImplementation.setName(name);
		this.gameDBDAO.load(name, this.connection);
		this.sessionImplementation.resetRegistry();
		this.sessionImplementation.registry();
		this.sessionImplementation.setValueState(StateValue.IN_GAME);
		if (this.sessionImplementation.isTicTacToe()) {
			this.sessionImplementation.setValueState(StateValue.RESUME);
		}
	}

	@Override
	public void save(String name) {
		this.gameDBDAO.save(name, this.connection, this.exists(name));
	}

	@Override
	public String[] getGamesNames() {
		String sql = "SELECT name FROM Games";
		ArrayList<String> gamesNames = new ArrayList<String>();
		try {
			Statement statement = this.connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				gamesNames.add(result.getString("name"));
			}
			result.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String[] names = new String[gamesNames.size()];
		for (int i = 0; i < gamesNames.size(); i++) {
			names[i] = gamesNames.get(i);
		}
		return names;
	}

	@Override
	public boolean exists(String name) {
		String sql = "SELECT name FROM Games";
		try {
			Statement statement = this.connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				if (result.getString("name").equals(name)) {
					return true;
				}
			}
			result.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
