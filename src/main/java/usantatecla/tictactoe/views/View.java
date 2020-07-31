package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.Controller;
import usantatecla.tictactoe.controllers.ControllersVisitor;

public abstract class View implements ControllersVisitor {

    public void interact(Controller controller) {
		controller.accept(this);
	}
}