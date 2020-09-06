package usantatecla.tictactoe.controllers;

import java.util.HashMap;
import java.util.Map;

import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.views.MovementCommand;
import usantatecla.tictactoe.views.RedoCommand;
import usantatecla.tictactoe.views.UndoCommand;
import usantatecla.utils.Command;
import usantatecla.utils.Menu;

public class PlayController extends Controller {

	private Map<Command, Controller> controllers;

	private MovementCommand movementCommand;

	private MovementController movementController;

	private UndoCommand undoCommand;

	private UndoController undoController;

	private RedoCommand redoCommand;

	private RedoController redoController;

	private Menu menu;
    
    public PlayController(Session session) {
		super(session);
		this.controllers = new HashMap<Command, Controller>();
		this.movementController = new MovementController(this.session);
		this.movementCommand = new MovementCommand();
		this.controllers.put(this.movementCommand, this.movementController);
		this.undoCommand = new UndoCommand();
		this.undoController = new UndoController(this.session);
		this.controllers.put(this.undoCommand, this.undoController);
		this.redoCommand = new RedoCommand();
		this.redoController = new RedoController(this.session);
		this.controllers.put(this.redoCommand, this.redoController);
		this.menu = new Menu(this.controllers.keySet());
	}

	@Override
	public void control() {
		this.movementCommand.setActive(true);
		this.undoCommand.setActive(this.undoController.undoable());
		this.redoCommand.setActive(this.redoController.redoable());
		this.controllers.get(this.menu.execute()).control();
	}
	
}