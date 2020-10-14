package usantatecla.tictactoe.views.graphics;

import java.awt.GridBagLayout;
import javax.swing.JFrame;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.Message;

@SuppressWarnings("serial")
public class StartView extends JFrame {

    private Game game;

    StartView(Game game) {
        super(Message.NUMBER_PLAYERS.getMessage());
        assert game != null;
        this.game = game;
        this.getContentPane().setLayout(new GridBagLayout());
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    void interact() {
        ChoosePlayersView choosePlayersView = new ChoosePlayersView(this.getRootPane());
        this.getContentPane().add(choosePlayersView, new Constraints(0, 0, 3, 1));
        this.setVisible(true);
        do {
            System.out.println("");
            if (choosePlayersView.getPlayersNumber() != null) {
                int numberPlayers = Integer.parseInt(choosePlayersView.getPlayersNumber());
                this.game.setUsers(numberPlayers);
                choosePlayersView.setVisible(false);
            }
        } while (choosePlayersView.getPlayersNumber() == null);
        GameView gameView;
        gameView = new GameView(this.game);
        gameView.write();
        this.getContentPane().add(gameView, new Constraints(0, 0, 3, 1));
        this.setVisible(false);
    }

}