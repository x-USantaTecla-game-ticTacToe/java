package usantatecla.tictactoe.distributed;

import usantatecla.tictactoe.TicTacToe;
import usantatecla.tictactoe.controllers.Logic;

public class TicTacToeClient extends TicTacToe{

	private LogicProxy logicProxy;
	
	@Override
	protected Logic createLogic() {
		this.logicProxy = new LogicProxy();
		return this.logicProxy;
	}

	@Override
	protected void play() {
		super.play();
		this.logicProxy.close();
	}
	
	public static void main(String[] args) {
		new TicTacToeClient().play();
	}

}
