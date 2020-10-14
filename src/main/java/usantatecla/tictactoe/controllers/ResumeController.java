package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.State;

public class ResumeController extends Controller {

  ResumeController(Game game, State state) {
    super(game, state);
  }

  public void resume(){
    this.game.reset();
    this.state.reset();
  }
  
}
