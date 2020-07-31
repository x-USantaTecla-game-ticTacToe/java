package usantatecla.tictactoe.views.console;

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

	public void visit(StartController startController) {
		this.startView.interact(startController);		
	}
	
	public void visit(PlayController playController) {
		this.playView.interact(playController);
	}
	
	public void visit(ResultController resultController) {
		this.resultView.interact(resultController);
	}
}