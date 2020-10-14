package usantatecla.tictactoe.views.graphics;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Error;
import usantatecla.tictactoe.views.ErrorView;

@SuppressWarnings("serial")
public class CoordinateMoveView extends CoordinateView {

    static final String ENTER_COORDINATE_TO_REMOVE = "Enter a coordinate to remove a token:";
    private final JLabel labelRowToMove;
    private final JLabel labelColumnToMove;
    private final JLabel titleLabelToMove;
    private final JTextField textFieldRowToMove;
    private final JTextField textFieldColumnToMove;
    private Coordinate[] coordinates;

    CoordinateMoveView() {
        super();
        this.resetCoordinates();
        this.titleLabel = new JLabel(ENTER_COORDINATE_TO_REMOVE);
        this.titleLabelToMove = new JLabel(ENTER_COORDINATE_TO_PUT);
        this.labelRowToMove = new JLabel("Row: ");
        this.labelColumnToMove = new JLabel("Column: ");
        this.textFieldRowToMove = new JTextField(1);
        this.textFieldColumnToMove = new JTextField(1);
        this.add(titleLabel, new Constraints(0, 0, 1, 1));
        this.add(titleLabelToMove, new Constraints(0, 5, 1, 1));
        this.add(labelRowToMove, new Constraints(0, 6, 1, 1));
        this.add(textFieldRowToMove, new Constraints(0, 7, 1, 1));
        this.add(labelColumnToMove, new Constraints(0, 8, 1, 1));
        this.add(textFieldColumnToMove, new Constraints(0, 9, 1, 1));
        this.button = new JButton(CoordinateView.ACCEPT);
        this.add(button, new Constraints(0, 10, 1, 1));
        this.button.addActionListener(this);
        this.button.addKeyListener(this);
    }

    void resetCoordinates() {
        this.coordinates = null;
    }

    Coordinate[] getCoordinates() {
        return this.coordinates;
    }

    public void actionPerformed(final ActionEvent event) {
        Coordinate originCoordinate = new Coordinate(Integer.parseInt(this.textFieldRow.getText()) - 1,
                Integer.parseInt(this.textFieldColumn.getText()) - 1);
        Coordinate targetCoordinate = new Coordinate(Integer.parseInt(this.textFieldRowToMove.getText()) - 1,
                Integer.parseInt(this.textFieldColumnToMove.getText()) - 1);
        if (originCoordinate.isValid().equals(Error.NULL)
                && targetCoordinate.isValid().equals(Error.NULL)) {
            this.coordinates = new Coordinate[2];
            this.coordinates[0] = originCoordinate;
            this.coordinates[1] = targetCoordinate;
        } else {
            JOptionPane.showMessageDialog(null, ErrorView.MESSAGES[Error.WRONG_COORDINATES.ordinal()], "ERROR",
                    JOptionPane.WARNING_MESSAGE);
        }
        this.textFieldRowToMove.setText("");
        this.textFieldColumnToMove.setText("");
        this.textFieldRow.setText("");
        this.textFieldColumn.setText("");
    }

}