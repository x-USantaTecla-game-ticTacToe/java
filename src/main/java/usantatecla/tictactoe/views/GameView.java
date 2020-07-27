package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Token;
import usantatecla.tictactoe.models.Turn;
import usantatecla.utils.WithConsoleModel;

class GameView extends WithConsoleModel {

    Game game;

    GameView(Game game) {
        this.game = game;
    }
    
    void readAndCreateUsers() {
        int numberOfUsers = this.console.readInt("Number of users [0-" + Turn.PLAYERS + "] ");
        this.game.createPlayers(numberOfUsers);
    }

    void writeWin(Token token) {
		new TokenView(token).write();
		this.console.writeln(" Player: You win!!! :-)");
	}
}