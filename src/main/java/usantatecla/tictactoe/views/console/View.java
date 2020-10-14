package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;

public class View extends usantatecla.tictactoe.views.View {

	private StartView startView;
	private PlayView playView;
	private ResumeView resumeView;

	public View(Logic logic) {
		this.startView = new StartView(logic);
		this.playView = new PlayView(logic);
		this.resumeView = new ResumeView(logic);
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
	protected boolean isResumed(){
		return this.resumeView.interact();
	}

}