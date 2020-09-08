package usantatecla.utils;

public abstract class Command extends Observed {

	protected String title;

	protected boolean isActive;

	protected boolean isActive() {
		return this.isActive;
	}

	String getTitle() {
		return this.title;
	}
	
	public abstract void updateIsActive();

	public abstract void execute();

}
