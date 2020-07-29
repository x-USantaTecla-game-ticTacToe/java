package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.utils.WithConsoleModel;

class ChoosePlayerView extends WithConsoleModel {

    Game game;

    ChoosePlayerView(Game game) {
        this.game = game;
    }
    
    void readAndCreateUsers() {
        int numberOfUsers = this.console.readInt(MessageView.CHOOSE_PLAYERS.getMessage());
        this.game.createPlayers(numberOfUsers);
    }
}