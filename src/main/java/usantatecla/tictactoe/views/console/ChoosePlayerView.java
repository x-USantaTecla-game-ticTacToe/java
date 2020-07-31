package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.views.MessageView;
import usantatecla.utils.WithConsoleView;
import usantatecla.tictactoe.models.Error;

class ChoosePlayerView extends WithConsoleView {
    
    int readPlayers() {
        return this.readUsersNumber();
    }

    private int readUsersNumber() {
		int users = 0;
		do {
			users = this.console.readInt(MessageView.CHOOSE_PLAYERS.getMessage());
			if (users < 0 || users > 2) {
				new ErrorView(Error.USERS_ERROR).writeln();
			}
		} while(users < 0 || users > 2);
		return users;
	}
}