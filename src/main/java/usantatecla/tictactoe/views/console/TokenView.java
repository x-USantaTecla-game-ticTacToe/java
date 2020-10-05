package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Token;
import usantatecla.utils.Console;

class TokenView {

	private static final char[] SYMBOLS = {'X', 'O', ' ' };
	private Token token;

	TokenView(Token token){
		this.token = token;
	}

	void write() {
		Console.instance().write(TokenView.SYMBOLS[token.ordinal()]);
	}

}