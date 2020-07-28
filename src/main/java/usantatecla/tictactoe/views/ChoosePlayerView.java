package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Game;
import usantatecla.utils.WithConsoleModel;

class ChoosePlayerView extends WithConsoleModel {

    Game game;

    ChoosePlayerView(Game game) {
        this.game = game;
    }
    
    void readAndCreateUsers() {
        int numberOfUsers = this.console.readInt(MessageView.CHOOSE_PLAYER.getMessage());
        this.game.createPlayers(numberOfUsers);
    }
}