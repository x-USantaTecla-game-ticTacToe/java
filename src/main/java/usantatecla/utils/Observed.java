package usantatecla.utils;

import java.util.ArrayList;

public class Observed {
	
	private ArrayList<Observer> observers;
	
	public Observed () {
		this.observers = new ArrayList<Observer>();
	}
	
	public void addObserver(Observer observer) {
		this.observers.add(observer);
	}
	
	public void notify(Event event) {
		for (Observer observer: this.observers) {
			observer.update(this, event);
		}
	}

}
