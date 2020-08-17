package usantatecla.utils;

public class PlayersDialog extends WithConsoleView {

	private static final String USERS_ERROR = "Wrong number of users";

	public int read(int players) {
		int users = 0;
		do {
			users = this.console.readInt("Number of users [0-" + players + "] ");
			assert users >= 0 && users < 3;
			if (users < 0 || users > 2) {
				this.console.writeln(PlayersDialog.USERS_ERROR);
			}
		} while(users < 0 || users > 2);
		return users;
	}
    
}