package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Controller;
import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResultController;
import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.views.View;

public class ConsoleView extends View {

	private StartView startView;

	private PlayView playView;

	private ResultView resultView;

	public ConsoleView() {
		this.startView = new StartView();
		this.playView = new PlayView();
		this.resultView = new ResultView();
	}

	@Override
	public void interact(Controller controller) {
		if (controller instanceof StartController) {
			this.startView.interact((StartController) controller);
		} else {
			if (controller instanceof PlayController) {
				this.playView.interact((PlayController) controller);
			} else {
				this.resultView.interact((ResultController) controller);
			}
		}
	}
}