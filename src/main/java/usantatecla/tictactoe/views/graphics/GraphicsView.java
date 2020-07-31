package usantatecla.tictactoe.views.graphics;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResultController;
import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.views.View;

public class GraphicsView extends View {

	private GameView gameView;

	public GraphicsView() {
		this.gameView = new GameView();
	}

	public void visit(StartController startController) {
		this.gameView.interact(startController);
	}

	
	public void visit(PlayController playController) {
		this.gameView.interact(playController);
	}

	
	public void visit(ResultController resultController) {
		this.gameView.interact(resultController);
	}

}
