package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.views.Message;

class GameView {
    
  private Logic logic;

  GameView(Logic logic) {
    this.logic = logic;
  }

	void write() {
		Message.SEPARATOR.writeln();
		for (int i = 0; i<Coordinate.DIMENSION; i++) {
			Message.VERTICAL_LINE_LEFT.write();
			for (int j = 0; j<Coordinate.DIMENSION; j++) {
				new TokenView(this.logic.getToken(new Coordinate(i, j))).write();;
				Message.VERTICAL_LINE_CENTERED.write();
			}
			Message.VERTICAL_LINE_RIGHT.writeln();
		}
		Message.SEPARATOR.writeln();
	}

}