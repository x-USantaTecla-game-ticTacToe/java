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

    private BoardFileDAO boardFileDAO;

    private TurnFileDAO turnFileDAO;

    GameFileDAO(Game game) {
        super(game);
        this.boardFileDAO = new BoardFileDAO(this.game.getBoard());
        this.turnFileDAO = new TurnFileDAO(this.game.getTurn());
	}

    public void save(FileWriter fileWriter) {
        try {
            this.boardFileDAO.save(fileWriter);
            fileWriter.write(this.game.getPlayerOrdinalTypeByIndex(0) + "\n");
            fileWriter.write(this.game.getPlayerOrdinalTokenByIndex(0) + "\n");
            fileWriter.write(this.game.getPlayerOrdinalTypeByIndex(1) + "\n");
            fileWriter.write(this.game.getPlayerOrdinalTokenByIndex(1) + "\n");
            this.turnFileDAO.save(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(BufferedReader bufferedReader) {
        try {
            this.boardFileDAO.load(bufferedReader);
            int typeFirstPlayer = Integer.parseInt(bufferedReader.readLine());
            int tokenFirstPlayer = Integer.parseInt(bufferedReader.readLine());
            this.game.setPlayerByIndex(new Player(Token.values()[tokenFirstPlayer], this.game.getBoard(),
            PlayerType.values()[typeFirstPlayer]), 0);
            int typeSecondPlayer = Integer.parseInt(bufferedReader.readLine());
            int tokenSecondPlayer = Integer.parseInt(bufferedReader.readLine());
            this.game.setPlayerByIndex(new Player(Token.values()[tokenSecondPlayer], this.game.getBoard(),
            PlayerType.values()[typeSecondPlayer]), 1);
            this.turnFileDAO.load(bufferedReader);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}