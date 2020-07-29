package usantatecla.tictactoe.views;

import usantatecla.utils.WithConsoleModel;

class ChoosePlayerView extends WithConsoleModel {
    
    int readPlayers() {
        return this.console.readInt(MessageView.CHOOSE_PLAYER.getMessage());
    }
}