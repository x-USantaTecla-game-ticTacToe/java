package usantatecla.tictactoe.models;

import java.util.ArrayList;

public class Registry {
    
    private ArrayList<Memento> mementoList;
	
	private Game game;
	
	private int firstPrevious;
	
	Registry(Game game) {
		this.game = game;
		this.mementoList = new ArrayList<Memento>();
		// this.mementoList.add(firstPrevious, this.game.createMemento());
		this.firstPrevious = 0;
	}

	void registry() {
		for (int i = 0; i < this.firstPrevious; i++) {
			this.mementoList.remove(0);
		}
		this.firstPrevious = 0;
		this.mementoList.add(this.firstPrevious, this.game.createMemento());
	}

	void undo(Game game) {
		this.firstPrevious++;
		game.set(this.mementoList.get(this.firstPrevious));
	}

	void redo(Game game) {
		this.firstPrevious--;
		game.set(this.mementoList.get(this.firstPrevious));
	}

	boolean undoable() {
		return this.firstPrevious < this.mementoList.size() - 1;
	}

	boolean redoable() {
		return this.firstPrevious >= 1;
	}

	void reset() {
		this.mementoList = new ArrayList<Memento>();
		// this.mementoList.add(firstPrevious, this.game.createMemento());
		this.firstPrevious = 0;
    }
    
}