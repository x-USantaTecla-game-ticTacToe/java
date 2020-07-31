package usantatecla.tictactoe.views;

import usantatecla.utils.WithConsoleView;
import usantatecla.tictactoe.models.Error;

class ChoosePlayerView extends WithConsoleView {
    
    int readPlayers() {
        return this.readUsersNumber();
    }

    private int readUsersNumber() {
		int users = 0;
		do {
			users = this.console.readInt(MessageView.CHOOSE_PLAYER.getMessage());
			if (users < 0 || users > 2) {
				new ErrorView(Error.USERS_ERROR).writeln();
			}
		} while(users < 0 || users > 2);
		return users;
	}
}