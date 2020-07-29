package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.views.MessageView;
import usantatecla.utils.WithConsoleModel;

class ChoosePlayerView extends WithConsoleModel {
    
    int readPlayers() {
        return this.console.readInt(MessageView.CHOOSE_PLAYERS.getMessage());
    }
}