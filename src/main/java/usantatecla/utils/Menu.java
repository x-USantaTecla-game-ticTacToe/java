package usantatecla.utils;

import java.util.ArrayList;

public abstract class Menu extends WithConsoleView{

	private static final String OPTION = "----- Choose one option -----";
	
	protected ArrayList<Command> commands;

	public void execute() {
		for (Command command: this.commands) {
			command.updateIsActive();
		}
		ArrayList<Command> commands = new ArrayList<Command>();
		for (Command command: this.commands) {
			if (command.isActive()) {
				commands.add(command);
			}
		}
		boolean error;
		int option;
		do {
			error = false;
			this.console.writeln();
			this.console.writeln(Menu.OPTION);
			for (int i = 0; i < commands.size(); i++) {
				this.console.writeln((i + 1) + ") " + commands.get(i).getTitle());
			}
			option = this.console.readInt("") - 1;
			if (!new ClosedInterval(0, commands.size()-1).includes(option)) {
				error = true;
			} 				
		} while (error);
		commands.get(option).execute();
	}

}
