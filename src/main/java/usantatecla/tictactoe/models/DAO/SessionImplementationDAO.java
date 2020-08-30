package usantatecla.tictactoe.models.DAO;

import usantatecla.tictactoe.models.SessionImplementation;

public abstract class SessionImplementationDAO {

    protected SessionImplementation sessionImplementation;
	
	public void associate(SessionImplementation sessionImplementation) {
		this.sessionImplementation = sessionImplementation;
	}

	public void save() {
		this.save(this.sessionImplementation.getName());
	}

	public abstract void save(String name);

	public abstract void load(String name);

	public abstract String[] getGamesNames();

	public abstract boolean exists(String name);
    
}