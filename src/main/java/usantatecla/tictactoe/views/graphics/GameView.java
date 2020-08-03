package usantatecla.tictactoe.views.graphics;

import java.awt.Container;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.ResultController;
import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.types.Token;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.tictactoe.views.PlayerView;
import usantatecla.tictactoe.views.TokenView;

@SuppressWarnings("serial")
class GameView extends JFrame {

	private static final String GAME_OVER = "Game Over";

	private StartController startController;

	private PlayController playController;

	private ResultController resultController;

	GameView(StartController startController, PlayController playController, ResultController resultController) {
		super(MessageView.START_GAME.getMessage());
		this.startController = startController;
		this.playController = playController;
		this.resultController = resultController;
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
				this.startController.createPlayers(numberPlayers);
			}
		} while (choosePlayersView.getPlayersNumber() == null);
	}

	boolean play() {
		this.getContentPane().removeAll();
		this.getContentPane().add(new BoardView(this.playController), new Constraints(0, 0, 1, 1));
		if (!this.playController.isBoardComplete()) {
			PlayerView playerView = this.playController.getTypeOfTokenPlayerFromTurn() == PlayerType.USER_PLAYER
					? new UserPlayerView(this.playController, false, this.getContentPane())
					: new MachinePlayerView(this.playController);
			this.setVisible(true);
			int[] coordinate = playerView.readCoordinateToPut();
			this.playController.putTokenPlayerFromTurn(coordinate[0], coordinate[1]);
		} else {
			PlayerView playerView = this.playController.getTypeOfTokenPlayerFromTurn() == PlayerType.USER_PLAYER
					? new UserPlayerView(this.playController, true, this.getContentPane())
					: new MachinePlayerView(this.playController);
			this.setVisible(true);
			int[][] coordinates = playerView.readCoordinatesToMove();
			this.playController.moveTokenPlayerFromTurn(coordinates[0][0], coordinates[0][1], coordinates[1][0],
					coordinates[1][1]);
		}
		this.playController.changeTurn();
		if (this.playController.isTicTacToe()) {
			Container container = this.getContentPane();
			container.removeAll();
			container.add(new BoardView(this.playController), new Constraints(0, 0, 1, 1));
			container.revalidate();
			container.repaint();
		}
		return this.playController.isTicTacToe();
	}

	void result() {
		int otherValue = this.resultController.getOtherValueFromTurn();
		String message = new TokenView(Token.values()[otherValue]).getToken() + " "
				+ MessageView.PLAYER_WIN.getMessage();
		JOptionPane.showMessageDialog(null, message, GameView.GAME_OVER, JOptionPane.WARNING_MESSAGE);
	}

}
