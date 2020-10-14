package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;

public class ResumeController extends Controller {

  ResumeController(Game game) {
    super(game);
  }

  public void resume(){
    this.game.reset();
  }
  
}
