package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.types.Error;

class PlayView {

    void interact(PlayController playController) {
        if (playController.isUser()) {
            new PlayMenu(playController).execute();
        } else {
            this.randomPlay(playController);
        }
        new GameView(playController).write();
    }

    private void randomPlay(PlayController playController) {
        Error error;
        Coordinate target;
        do {
            target = new Coordinate();
            target.random();
            if (!playController.isBoardComplete()) {
                error = playController.put(target);
            } else {
                Coordinate origin = new Coordinate();
                origin.random();
                error = playController.move(origin, target);
            }
        } while (!error.isNull());
    }

}