package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.views.Message;

class RedoCommand extends Command {

  RedoCommand(PlayController playController) {
    super(Message.REDO_COMMAND.getMessage(), playController);
  }

  @Override
  protected void execute() {
    this.playController.redo();
  }

  @Override
  protected boolean isActive() {
    return this.playController.redoable();
  }

}
