package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Token;
import usantatecla.utils.WithConsoleView;

class TokenView extends WithConsoleView {

	private Token token;

	TokenView(Token token){
		this.token = token;
	}

	void write() {
		this.console.write(this.token.getChar());
	}
}