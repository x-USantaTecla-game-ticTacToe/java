package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.utils.Console;

class PlayView {

    void interact(PlayController playController) {
        if (playController.isUser()) {
            new PlayMenu(playController).execute();
        } else {
            this.randomAction(playController);
        }
    }

    private void randomAction(PlayController playController) {
        Error error;
        Coordinate target;
        if (!playController.isBoardComplete()) {
            do {
                target = new Coordinate();
                target.random();
                error = playController.put(target);
                Console.instance().write("put: ");
                new ErrorView(error).writeln();
            } while (!error.isNull());
        } else {
            Coordinate origin;
            do {
                origin = new Coordinate();
                origin.random();
                target = new Coordinate();
                target.random();
                error = playController.move(origin, target);
                Console.instance().write("move: ");
                new ErrorView(error).writeln();
            } while (!error.isNull());
        }
    }

}