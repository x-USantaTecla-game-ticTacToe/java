package usantatecla.tictactoe.views.graphics;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;

import usantatecla.tictactoe.views.ErrorView;

@SuppressWarnings("serial")
class ChoosePlayersView extends JPanel implements ActionListener, KeyListener {

	private static final String ACCEPT = "Ok";
	private final JLabel label;
	private final JTextField textField;
	private final JButton button;
	private String playersNumber;

	ChoosePlayersView(final JRootPane rootPane) {
		this.setLayout(new GridBagLayout());
		this.label = new JLabel("Number of users [0- 2]");
		this.button = new JButton(ChoosePlayersView.ACCEPT);
		this.textField = new JTextField(10);
		this.resetPlayersNumber();
		this.add(label, new Constraints(0, 0, 1, 1));
		this.add(textField, new Constraints(0, 1, 1, 1));
		this.add(button, new Constraints(0, 2, 1, 1));
		rootPane.setDefaultButton(this.button);
		this.button.addActionListener(this);
		this.button.addKeyListener(this);
	}

	void resetPlayersNumber() {
		this.playersNumber = null;
	}

	String getPlayersNumber() {
		return this.playersNumber;
	}

	public void actionPerformed(final ActionEvent event) {
		String usersInsertedText = this.textField.getText();
		int usersInserted = Integer.parseInt(usersInsertedText);
		if (usersInserted >= 0 && usersInserted < 3) {
			this.playersNumber = usersInsertedText;
		} else {
			JOptionPane.showMessageDialog(null, ErrorView.MESSAGES[3], "ERROR", JOptionPane.WARNING_MESSAGE);
		}
		this.textField.setText("");
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}
}