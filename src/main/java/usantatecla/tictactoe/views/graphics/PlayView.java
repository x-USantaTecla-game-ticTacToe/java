package usantatecla.tictactoe.views.graphics;

import java.awt.Container;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.Player;
import usantatecla.tictactoe.models.PlayerType;
import usantatecla.tictactoe.models.Token;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.tictactoe.views.PlayerView;

@SuppressWarnings("serial")
class PlayView extends JFrame {

	private static final String GAME_OVER = "Game Over";
	private Game game;

	PlayView(Game game) {
		super(MessageView.START_GAME.getMessage());
		this.game = game;
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
				this.game.createPlayers(numberPlayers);
			}
		} while (choosePlayersView.getPlayersNumber() == null);
	}

	boolean play() {
		this.getContentPane().removeAll();
		this.getContentPane().add(new BoardView(this.game.getBoard()), new Constraints(0, 0, 1, 1));
		PlayerView playerView = this.createPlayerView();
		this.setVisible(true);
		if (!this.game.isBoardComplete()) {
			Coordinate coordinate = playerView.readCoordinateToPut();
			this.game.put(coordinate);
		} else {
			Coordinate[] coordinates = playerView.readCoordinatesToMove();
			this.game.move(coordinates);
		}
		if (this.game.isTicTacToe()) {
			Container container = this.getContentPane();
			container.removeAll();
			container.add(new BoardView(game.getBoard()), new Constraints(0, 0, 1, 1));
			container.revalidate();
			container.repaint();
			int value = this.game.getValueFromTurn();
			String message = Token.values()[value].getChar() + " " + MessageView.PLAYER_WIN.getMessage();
			JOptionPane.showMessageDialog(null, message, PlayView.GAME_OVER, JOptionPane.WARNING_MESSAGE);
			return true;
		}
		this.game.changeTurn();
		return false;
	}

	private PlayerView createPlayerView() {
		return this.game.isUser()
				? new UserPlayerView(this.game.getTokenPlayerFromTurn(), false, this.getContentPane())
				: new MachinePlayerView(this.game.getTokenPlayerFromTurn());
	}

}
