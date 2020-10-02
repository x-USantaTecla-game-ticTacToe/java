package usantatecla.utils;

public class YesNoDialog {

	private static final char AFFIRMATIVE = 'y';
	private static final char NEGATIVE = 'n';
	private static final String SUFFIX = "? (" +
		YesNoDialog.AFFIRMATIVE+"/" + 
		YesNoDialog.NEGATIVE+"): ";
	private static final String MESSAGE = "The value must be '" + 
		YesNoDialog.AFFIRMATIVE + "' or '" + 
		YesNoDialog.NEGATIVE + "'";
	private char answer;

	public boolean read(String message) {
		assert message != null;
		
		Console console = Console.instance();
		boolean error;
		do {
			console.write(message);
			this.answer = console.readChar(YesNoDialog.SUFFIX);
			error = !this.isAfirmative() && !this.isNegative();
			if (error) {
				console.writeln(YesNoDialog.MESSAGE);
			}
		} while (error);
		return this.isAfirmative();
	}

	private boolean isAfirmative() {
		return this.getAnswer() == YesNoDialog.AFFIRMATIVE;
	}

	private char getAnswer(){
		return Character.toLowerCase(this.answer);
	}

	private boolean isNegative() {
		return Character.toLowerCase(this.answer) == YesNoDialog.NEGATIVE;
	}

}
