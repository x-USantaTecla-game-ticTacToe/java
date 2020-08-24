package usantatecla.tictactoe.views;

import usantatecla.tictactoe.controllers.SaveController;
import usantatecla.tictactoe.views.models.MessageView;
import usantatecla.utils.WithConsoleView;
import usantatecla.utils.YesNoDialog;

class SaveView extends WithConsoleView {

	void interact(SaveController saveController) {
		boolean save = new YesNoDialog().read(MessageView.SAVE.getMessage());
		String name = null;
		if (save) {
			if (saveController.hasName()) {
				saveController.save();
			} else {
				boolean exists = false;
				do {
					name = this.console.readString(MessageView.NAME.getMessage());
					exists = saveController.exists(name);
					if (exists) {
						this.console.writeln(MessageView.ALREADY_EXIST.getMessage());
					}
				} while (exists);
				saveController.save(name);
			}
		}
		saveController.next();
	}

}
