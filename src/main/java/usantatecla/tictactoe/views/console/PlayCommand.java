package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.views.Message;

class PlayCommand extends Command {

  PlayCommand(PlayController playController) {
    super(Message.ACTION_COMMAND.getMessage(), playController);
  }

  @Override
  protected void execute() {
    if (!playController.isBoardComplete()) {
      this.put(playController);
    } else {
      this.move(playController);
    }
    if (playController.isTicTacToe()) {
      new TokenView(playController.getToken()).write();
      Message.PLAYER_WIN.writeln();
    }
  }

  private void put(PlayController playController) {
    Coordinate coordinate;
    Error error;
    do {
      coordinate = new CoordinateView().read(Message.COORDINATE_TO_PUT.toString());
      error = playController.put(coordinate);
      new ErrorView(error).writeln();
    } while (!error.isNull());
  }

  private void move(PlayController playController) {
    Coordinate origin;
    Coordinate target;
    Error error;
    do {
      origin = new CoordinateView().read(Message.COORDINATE_TO_REMOVE.toString());
      target = new CoordinateView().read(Message.COORDINATE_TO_MOVE.toString());
      error = playController.move(origin, target);
      new ErrorView(error).writeln();
    } while (!error.isNull());
  }

  @Override
  protected boolean isActive() {
    return true;
  }

}
