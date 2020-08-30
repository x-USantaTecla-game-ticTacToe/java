package usantatecla.tictactoe.models.Files;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Player;
import usantatecla.tictactoe.models.DAO.GameDAO;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.types.Token;

class GameFileDAO extends GameDAO implements FileDAO {

    private BoardFileDAO boardDAO;

    private TurnFileDAO turnDAO;

    GameFileDAO(Game game) {
        super(game);
        this.boardDAO = new BoardFileDAO(this.game.getBoard());
        this.turnDAO = new TurnFileDAO(this.game.getTurn());
	}

    public void save(FileWriter fileWriter) {
        try {
            this.boardDAO.save(fileWriter);
            fileWriter.write(this.game.getPlayerOrdinalTypeByIndex(0) + "\n");
            fileWriter.write(this.game.getPlayerOrdinalTokenByIndex(0) + "\n");
            fileWriter.write(this.game.getPlayerOrdinalTypeByIndex(1) + "\n");
            fileWriter.write(this.game.getPlayerOrdinalTokenByIndex(1) + "\n");
            this.turnDAO.save(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(BufferedReader bufferedReader) {
        try {
            this.boardDAO.load(bufferedReader);
            int typeFirstPlayer = Integer.parseInt(bufferedReader.readLine());
            int tokenFirstPlayer = Integer.parseInt(bufferedReader.readLine());
            this.game.setPlayerByIndex(new Player(Token.values()[tokenFirstPlayer], this.game.getBoard(),
            PlayerType.values()[typeFirstPlayer]), 0);
            int typeSecondPlayer = Integer.parseInt(bufferedReader.readLine());
            int tokenSecondPlayer = Integer.parseInt(bufferedReader.readLine());
            this.game.setPlayerByIndex(new Player(Token.values()[tokenSecondPlayer], this.game.getBoard(),
            PlayerType.values()[typeSecondPlayer]), 1);
            this.turnDAO.load(bufferedReader);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}