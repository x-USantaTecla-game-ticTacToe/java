package usantatecla.utils;

public class LimitedIntDialog {

	private final int LIMIT;
	private static final String ERROR_MESSAGE = "Invalid number";

	public LimitedIntDialog(int limit){
		this.LIMIT = limit;
	}

	public int read(String message) {
		boolean error;
		int value;
		do {
			value = Console.instance().readInt(message + "? [0-" + this.LIMIT + "] ");
			error = !new ClosedInterval(this.LIMIT).isIncluded(value);
			if (error) {
				Console.instance().writeln(LimitedIntDialog.ERROR_MESSAGE);
			}
		} while(error);
		return value;
	}
    
}