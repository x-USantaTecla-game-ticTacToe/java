package usantatecla.utils;

public class LimitedIntDialog {

	private final ClosedInterval LIMITS;
	private static final String ERROR_MESSAGE = "Invalid number";

	public LimitedIntDialog(int min, int max){
		this.LIMITS = new ClosedInterval(min, max);
	}

	public int read(String message) {
		assert message != null;
		
		boolean error;
		int value;
		do {
			value = Console.instance().readInt(message + "? " + this.LIMITS + ": ");
			error = !this.LIMITS.isIncluded(value);
			if (error) {
				Console.instance().writeln(LimitedIntDialog.ERROR_MESSAGE);
			}
		} while(error);
		return value;
	}
    
}
