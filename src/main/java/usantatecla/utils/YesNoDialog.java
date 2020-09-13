package usantatecla.utils;

public class YesNoDialog {

	private static final char AFIRMATIVE = 'y';
	private static final char NEGATIVE = 'n';
	private static final String QUESTION = "? (" +
		YesNoDialog.AFIRMATIVE+"/" + 
		YesNoDialog.NEGATIVE+"): ";
	private static final String MESSAGE = "The value must be '" + 
		YesNoDialog.AFIRMATIVE + "' or '" + 
		YesNoDialog.NEGATIVE + "'";
	private char answer;

	public boolean read(String message) {
		assert message != null;
		
		boolean error;
		do {
			Console console = Console.instance();
			console.write(message);
			this.answer = console.readChar(YesNoDialog.QUESTION);
			error = !this.isAfirmative() && !this.isNegative();
			if (error) {
				console.writeln(YesNoDialog.MESSAGE);
			}
		} while (error);
		return this.isAfirmative();
	}

	private boolean isAfirmative() {
		return Character.toLowerCase(this.answer) == YesNoDialog.AFIRMATIVE;
	}

	private boolean isNegative() {
		return Character.toLowerCase(this.answer) == YesNoDialog.NEGATIVE;
	}

}
