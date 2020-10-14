package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Game;

public class View extends usantatecla.tictactoe.views.View {

	private StartView startView;
	private PlayView playView;
	private ResumeView resumeView;

	public View(Game game) {
		super(game);
		this.startView = new StartView(this.game);
		this.playView = new PlayView(this.game);
		this.resumeView = new ResumeView(this.game);
	}

	@Override
	protected void start(){
		this.startView.interact();
	}

	@Override
	protected void play(){
		this.playView.interact();
	}

	@Override
	protected boolean isNewGame(){
		return this.resumeView.interact();
	}

}