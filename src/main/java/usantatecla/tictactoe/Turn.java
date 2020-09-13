package usantatecla.tictactoe;

import usantatecla.utils.LimitedIntDialog;

class Turn {
	
	static final int NUMBER_PLAYERS = 2;
	private Player[] players;
	private int active;

	Turn(Board board) {
		assert board != null;
		
		Message.TITTLE.writeln();
		int numberUsers = new LimitedIntDialog(0, Turn.NUMBER_PLAYERS)
			.read(Message.NUMBER_PLAYERS.toString());
		this.players = new Player[Turn.NUMBER_PLAYERS];
		for (int i = 0; i < Turn.NUMBER_PLAYERS; i++) {
			if (i < numberUsers){
				this.players[i] = new UserPlayer(Token.get(i), board);
			} else {
				this.players[i] = new MachinePlayer(Token.get(i), board);
			}
		}
		this.active = Turn.NUMBER_PLAYERS-1;
	}

	void play(){
		this.active = (this.active+1) % Turn.NUMBER_PLAYERS;
		this.getPlayer().play();
	}

	private Player getPlayer() {
		return this.players[this.active];
	}

	void writeWinner(){
		this.getPlayer().writeWinner();
	}

	Token getToken() {
		return this.getPlayer().getToken();
	}

}
