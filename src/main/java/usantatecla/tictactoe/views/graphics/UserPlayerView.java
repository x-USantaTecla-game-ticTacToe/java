package usantatecla.tictactoe.views.graphics;

import javax.swing.JOptionPane;

import java.awt.Container;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.views.ErrorView;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.tictactoe.views.PlayerView;

class UserPlayerView extends PlayerView {
    static final String ENTER_COORDINATE_TO_PUT = "Enter a coordinate to put a token:";
    static final String ENTER_COORDINATE_TO_REMOVE = "Enter a coordinate to remove a token:";

    CoordinatePutView coordinatePutView;
    CoordinateMoveView coordinateMoveView;

    UserPlayerView(PlayController playController, boolean isMovement, Container panel) {
        super(playController);
        if (isMovement) {
            this.coordinateMoveView = new CoordinateMoveView(playController);
            panel.add(this.coordinateMoveView, new Constraints(0, 1, 3, 1));
        } else {
            this.coordinatePutView = new CoordinatePutView(playController);
            panel.add(this.coordinatePutView, new Constraints(0, 1, 3, 1));
        }
    }

    @Override
    public int[] readCoordinateToPut() {
        int[] coordinate = new int[2];
        Error error;
        do {
            System.out.println("");
            if (this.coordinatePutView.getCoordinate() != null) {
                coordinate = this.coordinatePutView.getCoordinate();
                error = controlErrorsPutCoordinate(coordinate[0], coordinate[1]);
                if (error != null) {
                    JOptionPane.showMessageDialog(null, ErrorView.MESSAGES[error.ordinal() - 1],
                            MessageView.ERROR.getMessage(), JOptionPane.WARNING_MESSAGE);
                    this.coordinatePutView.resetCoordinate();
                }
            }
        } while (this.coordinatePutView.getCoordinate() == null);
        return coordinate;
    }

    @Override
    public int[][] readCoordinatesToMove() {
        int[][] coordinates = new int[2][2];
        Error error;
        do {
            System.out.println("");
            if (this.coordinateMoveView.getCoordinates() != null) {
                coordinates = this.coordinateMoveView.getCoordinates();
                error = controlErrorsMoveOriginCoordinate(coordinates[0][0], coordinates[0][1]);
                if (error != null) {
                    JOptionPane.showMessageDialog(null, ErrorView.MESSAGES[error.ordinal() - 1],
                            MessageView.ERROR.getMessage(), JOptionPane.WARNING_MESSAGE);
                    this.coordinateMoveView.resetCoordinates();
                }
                error = controlErrorsMoveTargetCoordinate(coordinates[0][0], coordinates[0][1], coordinates[1][0],
                        coordinates[1][1]);
                if (error != null) {
                    JOptionPane.showMessageDialog(null, ErrorView.MESSAGES[error.ordinal() - 1],
                            MessageView.ERROR.getMessage(), JOptionPane.WARNING_MESSAGE);
                    this.coordinateMoveView.resetCoordinates();
                }
            }
        } while (this.coordinateMoveView.getCoordinates() == null);
        return coordinates;
    }
}