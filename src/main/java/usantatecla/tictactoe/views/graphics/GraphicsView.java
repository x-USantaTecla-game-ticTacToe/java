package usantatecla.tictactoe.views.graphics;

import usantatecla.tictactoe.controllers.Controller;
import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResultController;
import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.views.View;

public class GraphicsView extends View {

	private GameView gameView;

	public GraphicsView() {
		this.gameView = new GameView();
	}

	@Override
	public void interact(Controller controller) {
		if (controller instanceof StartController) {
			this.gameView.interact((StartController) controller);
		} else {
			if (controller instanceof PlayController) {
				this.gameView.interact((PlayController) controller);
			} else {
				this.gameView.interact((ResultController) controller);
			}
		}
	}

}
