package usantatecla.tictactoe.views.graphics;

import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.ErrorView;
import usantatecla.tictactoe.views.Message;
import usantatecla.tictactoe.models.Error;

@SuppressWarnings("serial")
class PlayView extends JFrame {

	static final String ENTER_COORDINATE_TO_PUT = "Enter a coordinate to put a token:";
	static final String ENTER_COORDINATE_TO_REMOVE = "Enter a coordinate to remove a token:";
	private CoordinatePutView coordinatePutView;
	private CoordinateMoveView coordinateMoveView;
	private Game game;
	private GameView gameView;

	PlayView(Game game) {
		super(Message.NUMBER_PLAYERS.getMessage());
		assert game != null;

		this.game = game;
		this.getContentPane().setLayout(new GridBagLayout());
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.gameView = new GameView(game);
		this.getContentPane().add(this.gameView);
		this.gameView.write();
		this.setVisible(true);
		this.coordinatePutView = new CoordinatePutView();
		this.getContentPane().add(this.coordinatePutView, new Constraints(0, 1, 3, 1));
		this.gameView.removeAll();
		this.setVisible(true);
	}

	void interact() {
		this.gameView.removeAll();
		this.gameView.write();
		this.setVisible(true);
		do {
			this.game.next();
			if (!this.game.isBoardComplete()) {
				this.put();
			} else {
				this.move();
			}
			this.gameView.write();
			this.setVisible(true);
		} while (!this.game.isTicTacToe());
		this.getContentPane().add(new JLabel(this.game.getToken().toString() + Message.PLAYER_WIN.getMessage()),
				new Constraints(0, 1, 4, 1));
		this.setVisible(true);
	}

	private void put() {
		boolean isUser = this.game.isUser();
		Coordinate coordinate = new Coordinate();
		Error error;
		do {
			if (isUser) {
				this.setVisible(true);
				do {
					coordinate = this.coordinatePutView.getCoordinate();
					System.out.println("");
				} while (this.coordinatePutView.getCoordinate() == null);
				error = this.game.put(new Coordinate(this.coordinatePutView.getCoordinate().getColumn(),
						this.coordinatePutView.getCoordinate().getRow()));
				this.coordinatePutView.resetCoordinate();
				coordinate = null;
			} else {
				coordinate = new Coordinate();
				coordinate.random();
				error = this.game.put(coordinate);
			}
			if (isUser) {
				if (error != Error.NULL) {
					JOptionPane.showMessageDialog(null, ErrorView.MESSAGES[error.ordinal() - 1], "ERROR",
							JOptionPane.WARNING_MESSAGE);
					this.coordinatePutView.resetCoordinate();
				}
			}
		} while (!error.isNull());
	}

	private void move() {
		boolean isUser = this.game.isUser();
		Coordinate origin;
		Coordinate target;
		Error error;
		Coordinate[] coordinates = new Coordinate[2];
		do {
			if (isUser) {
				coordinates = this.coordinateMoveView.getCoordinates();
				error = this.game.move(coordinates[0], coordinates[1]);
			} else {
				origin = new Coordinate();
				origin.random();
				target = new Coordinate();
				target.random();
				error = this.game.move(origin, target);
			}
			if (isUser) {
				if (error != Error.NULL) {
					JOptionPane.showMessageDialog(null, ErrorView.MESSAGES[error.ordinal() - 1], "ERROR",
							JOptionPane.WARNING_MESSAGE);
					this.coordinatePutView.resetCoordinate();
				}
			}
		} while (!error.isNull());
	}

}