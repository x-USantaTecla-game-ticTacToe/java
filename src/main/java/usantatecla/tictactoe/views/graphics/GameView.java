package usantatecla.tictactoe.views.graphics;

import java.awt.Container;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.types.Token;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.tictactoe.views.PlayerView;

@SuppressWarnings("serial")
class GameView extends JFrame {

	private static final String GAME_OVER = "Game Over";

	GameView() {
		super(MessageView.START_GAME.getMessage());
		this.getContentPane().setLayout(new GridBagLayout());
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	void interact(StartController startController) {
		startController.start();
		ChoosePlayersView choosePlayersView = new ChoosePlayersView(this.getRootPane());
		this.getContentPane().add(choosePlayersView, new Constraints(0, 0, 3, 1));
		this.setVisible(true);
		do {
			System.out.println("");
			if (choosePlayersView.getPlayersNumber() != null) {
				int numberPlayers = Integer.parseInt(choosePlayersView.getPlayersNumber());
				startController.createPlayers(numberPlayers);
			}
		} while (choosePlayersView.getPlayersNumber() == null);
	}

	void interact(PlayController playController) {
		this.getContentPane().removeAll();
		this.getContentPane().add(new BoardView(playController), new Constraints(0, 0, 1, 1));
		if (!playController.isBoardComplete()) {
			PlayerView playerView = playController.getTypeOfTokenPlayerFromTurn() == PlayerType.USER_PLAYER
					? new UserPlayerView(playController, false, this.getContentPane())
					: new MachinePlayerView(playController);
			this.setVisible(true);
			Coordinate coordinate = playerView.readCoordinateToPut();
			playController.putTokenPlayerFromTurn(coordinate);
		} else {
			PlayerView playerView = playController.getTypeOfTokenPlayerFromTurn() == PlayerType.USER_PLAYER
					? new UserPlayerView(playController, true, this.getContentPane())
					: new MachinePlayerView(playController);
			this.setVisible(true);
			Coordinate[] coordinates = playerView.readCoordinatesToMove();
			playController.moveTokenPlayerFromTurn(coordinates[0], coordinates[1]);
		}
		if (playController.isTicTacToe()) {
			this.result(playController);
		}
		playController.changeTurn();
	}

	private void result(PlayController playController) {
		Container container = this.getContentPane();
		container.removeAll();
		container.add(new BoardView(playController), new Constraints(0, 0, 1, 1));
		container.revalidate();
		container.repaint();
		int value = playController.getValueFromTurn();
		String message = Token.values()[value].getChar() + " "
				+ MessageView.PLAYER_WIN.getMessage();
		JOptionPane.showMessageDialog(null, message, GameView.GAME_OVER, JOptionPane.WARNING_MESSAGE);
		playController.continueState();
	}

}
