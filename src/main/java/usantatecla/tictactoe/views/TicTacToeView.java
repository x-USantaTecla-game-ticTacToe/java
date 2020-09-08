package usantatecla.tictactoe.views;

import usantatecla.tictactoe.events.NewGameEvent;
import usantatecla.tictactoe.events.OPlayerWinnerEvent;
import usantatecla.tictactoe.events.XPlayerWinnerEvent;
import usantatecla.tictactoe.models.TicTacToe;
import usantatecla.tictactoe.types.Token;
import usantatecla.utils.Event;
import usantatecla.utils.Observed;
import usantatecla.utils.Observer;
import usantatecla.utils.YesNoDialog;

public class TicTacToeView extends Observed implements Observer {

    private TicTacToe tictactoe;

	private Menu menu;

	public TicTacToeView(TicTacToe tictactoe, Observer observer) {
		this.tictactoe = tictactoe;
		this.menu = new Menu(tictactoe, observer);
	}

	public void write() {
		new StartView().write();
		do {
			this.menu.execute();
		} while (!this.tictactoe.isTicTacToe());
	}

	public void update(final Observed observed, final Event event) {
		if (event instanceof OPlayerWinnerEvent) {
			new ResultView().write(Token.TOKEN_O.getChar());
			this.resume();
		} else if (event instanceof XPlayerWinnerEvent) {
			new ResultView().write(Token.TOKEN_X.getChar());
			this.resume();
		}
	}

	private void resume() {
		if (new YesNoDialog().read(MessageView.RESUME.getMessage())) {
			this.notify(new NewGameEvent());
		}
	}
    
}
