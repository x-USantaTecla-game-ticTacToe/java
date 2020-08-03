package usantatecla.tictactoe.views.graphics;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.views.ErrorView;
import usantatecla.tictactoe.views.MessageView;

@SuppressWarnings("serial")
public class CoordinatePutView extends CoordinateView {

	private int[] coordinate;

	CoordinatePutView(Logic logic) {
		super(logic);
		this.resetCoordinate();
		this.titleLabel = new JLabel(ENTER_COORDINATE_TO_PUT);
		this.add(titleLabel, new Constraints(0, 0, 1, 1));
		this.button = new JButton(CoordinateView.ACCEPT);
		this.add(button, new Constraints(0, 5, 1, 1));
		this.button.addActionListener(this);
		this.button.addKeyListener(this);
	}

	void resetCoordinate() {
		this.coordinate = null;
	}

	int[] getCoordinate() {
		return this.coordinate;
	}

	public void actionPerformed(final ActionEvent event) {
		int[] coordinateInserted = new int[2];
		coordinateInserted[0] = Integer.parseInt(this.textFieldRow.getText()) - 1;
		coordinateInserted[1] = Integer.parseInt(this.textFieldColumn.getText()) - 1;
		if (this.logic.isCoordinateValid(coordinateInserted[0], coordinateInserted[1])) {
			this.coordinate = coordinateInserted;
		} else {
			JOptionPane.showMessageDialog(null, ErrorView.MESSAGES[Error.WRONG_COORDINATES.ordinal()],
					MessageView.ERROR.getMessage(), JOptionPane.WARNING_MESSAGE);
		}
		this.textFieldRow.setText("");
		this.textFieldColumn.setText("");
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}