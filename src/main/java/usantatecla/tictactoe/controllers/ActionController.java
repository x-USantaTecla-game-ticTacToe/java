package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.Token;

public class ActionController extends UseCaseController {

	public ActionController(Session session) {
    super(session);
  }
  
  public boolean isBoardComplete() {
		return this.session.isBoardComplete();
	}

	public boolean isTicTacToe() {
		return this.session.isTicTacToe();
	}

	public Token getToken() {
		return this.session.getToken();
	}

	public boolean isUser() {
		return this.session.isUser();
	}

	public Error put(Coordinate coordinate) {
		Error error = this.session.put(coordinate);
		if (error.isNull() && this.session.isTicTacToe()) {
			this.session.next();
		}
		return error;
	}

	public Error move(Coordinate origin, Coordinate target) {
		Error error = this.session.move(origin, target);
		if (error.isNull() && this.session.isTicTacToe()) {
			this.session.next();
		}
		return error;
	}

}
