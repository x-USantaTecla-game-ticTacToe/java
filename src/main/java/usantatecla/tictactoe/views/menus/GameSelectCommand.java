package usantatecla.tictactoe.views.menus;

import usantatecla.tictactoe.controllers.StartController;

class GameSelectCommand extends Command {

	protected GameSelectCommand(String title, StartController startController) {
		super(title, startController);
	}

	@Override
	protected void execute() {
		this.console.writeln(this.title);
		((StartController) this.acceptorController).start(this.title);
	}

	@Override
	protected boolean isActive() {
		return true;
	}

}
