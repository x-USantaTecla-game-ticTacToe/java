package usantatecla.tictactoe.views.graphics;

import java.awt.Container;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.types.Token;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.tictactoe.views.PlayerView;

@SuppressWarnings("serial")
class GameView extends JFrame {

	private static final String GAME_OVER = "Game Over";

	private Logic logic;

	GameView(Logic logic) {
		super(MessageView.START_GAME.getMessage());
		this.logic = logic;
		this.getContentPane().setLayout(new GridBagLayout());
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	void start() {
		ChoosePlayersView choosePlayersView = new ChoosePlayersView(this.getRootPane());
		this.getContentPane().add(choosePlayersView, new Constraints(0, 0, 3, 1));
		this.setVisible(true);
		do {
			System.out.println("");
			if (choosePlayersView.getPlayersNumber() != null) {
				int numberPlayers = Integer.parseInt(choosePlayersView.getPlayersNumber());
				this.logic.createPlayers(numberPlayers);
			}
		} while (choosePlayersView.getPlayersNumber() == null);
	}

	boolean play() {
		this.getContentPane().removeAll();
		this.getContentPane().add(new BoardView(this.logic), new Constraints(0, 0, 1, 1));
		if (!this.logic.isBoardComplete()) {
			PlayerView playerView = this.logic.getTypeOfTokenPlayerFromTurn() == PlayerType.USER_PLAYER
					? new UserPlayerView(this.logic, false, this.getContentPane())
					: new MachinePlayerView(this.logic);
			this.setVisible(true);
			int[] coordinate = playerView.readCoordinateToPut();
			this.logic.putTokenPlayerFromTurn(coordinate[0], coordinate[1]);
		} else {
			PlayerView playerView = this.logic.getTypeOfTokenPlayerFromTurn() == PlayerType.USER_PLAYER
					? new UserPlayerView(this.logic, true, this.getContentPane())
					: new MachinePlayerView(this.logic);
			this.setVisible(true);
			int[][] coordinates = playerView.readCoordinatesToMove();
			this.logic.moveTokenPlayerFromTurn(coordinates[0][0], coordinates[0][1], coordinates[1][0],
					coordinates[1][1]);
		}
		this.logic.changeTurn();
		if (this.logic.isTicTacToe()) {
			Container container = this.getContentPane();
			container.removeAll();
			container.add(new BoardView(this.logic), new Constraints(0, 0, 1, 1));
			container.revalidate();
			container.repaint();
		}
		return this.logic.isTicTacToe();
	}

	void result() {
		int otherValue = this.logic.getOtherValueFromTurn();
		String message = Token.values()[otherValue].getChar() + " "
				+ MessageView.PLAYER_WIN.getMessage();
		JOptionPane.showMessageDialog(null, message, GameView.GAME_OVER, JOptionPane.WARNING_MESSAGE);
	}

}
