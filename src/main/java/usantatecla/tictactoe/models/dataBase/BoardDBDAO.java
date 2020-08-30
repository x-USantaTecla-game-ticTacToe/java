package usantatecla.tictactoe.models.dataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import usantatecla.tictactoe.models.Board;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Turn;
import usantatecla.tictactoe.models.DAO.BoardDAO;

public class BoardDBDAO extends BoardDAO implements DBDAO {

    protected BoardDBDAO(Board board) {
		super(board);
	}

    public void save(String name, Connection connection, boolean exists) {
		if (exists) {
			String sql = "DELETE FROM Boards WHERE name = '" + name + "';";
			try {
				Statement statement = connection.createStatement();
				statement.executeUpdate(sql);
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		this.insertBoard(name, connection);
	}

	private void insertBoard(String name, Connection connection) {
		Coordinate[][] coordinates = this.board.getCoordinates();
        String sql = "INSERT INTO Boards VALUES ('" + name + "','" 
                        + this.getCoordinateToSave(coordinates[0][0]) + "','" 
                        + this.getCoordinateToSave(coordinates[0][1]) + "','"
                        + this.getCoordinateToSave(coordinates[0][2]) + "','"
                        + this.getCoordinateToSave(coordinates[1][0]) + "','"
                        + this.getCoordinateToSave(coordinates[1][1]) + "','"
                        + this.getCoordinateToSave(coordinates[1][2])
                        + "');";
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    private String getCoordinateToSave(Coordinate coordinate) {
        if (coordinate == null) {
            return "" + Board.EMPTY;
        }
        return coordinate.getRow() + "." + coordinate.getColumn();
    }

	
	public void load(String name, Connection connection) {
		String sql = "SELECT * FROM Boards WHERE name = '" + name + "';";
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			if (result.next()) {
				for (int i = 0; i < Turn.NUM_PLAYERS; i++) {
					for (int j = 0; j < Coordinate.DIMENSION; j++) {
						String tokenCoordinate = result.getString("player" + (i + 1) + "Coordinate" + (j + 1));
						this.loadCoordinateInBoard(tokenCoordinate, i, j);
					}
				}
			}
			result.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
}