package usantatecla.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console {

	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public String readString(String title) {
		String input = null;
		boolean ok = false;
		do {
			this.write(title);
			try {
				input = this.bufferedReader.readLine();
				ok = true;
			} catch (Exception ex) {
				this.writeError("characte string");
			}
			assert ok;
		} while (!ok);
		return input;
	}

	public String readString() {
		return this.readString("");
	}

	public int readInt(String title) {
		int input = 0;
		boolean ok = false;
		do {
			try {
				input = Integer.parseInt(this.readString(title));
				ok = true;
			} catch (Exception ex) {
				this.writeError("integer");
			}
			assert ok;
		} while (!ok);
		return input;
	}

	public char readChar(String title) {
		char charValue = ' ';
		boolean ok = false;
		do {
			String input = this.readString(title);
			if (input.length() != 1) {
				this.writeError("character");
			} else {
				charValue = input.charAt(0);
				ok = true;
			}
			assert ok;
		} while (!ok);
		return charValue;
	}

	public void writeln() {
		System.out.println();
	}

	public void write(String string) {
		System.out.print(string);
	}

	public void write(int integer) {
		System.out.print(integer);
	}

	public void writeln(String string) {
		System.out.println(string);
	}

	public void writeln(int integer) {
		System.out.println(integer);
	}

	public void write(char character) {
		System.out.print(character);
	}

	public void writeError(String format) {
		System.out.println("FORMAT ERROR! " + "Enter a " + format + " formatted value.");
	}

}
