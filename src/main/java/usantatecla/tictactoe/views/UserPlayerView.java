package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Coordinate;

public class UserPlayerView {

    public Coordinate readCoordinate(String textToDisplay) {
        Coordinate coordinate = new CoordinateView().read(textToDisplay);
        return coordinate;
    }
}