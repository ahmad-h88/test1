package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {

	private PrintWriter writer;
	private Scanner reader;

	public Menu(InputStream input, OutputStream output) {
		this.writer = new PrintWriter(output);
		this.reader = new Scanner(input);
	}

	public Object getUserInput(String message){
		System.out.println(message);
		Object input = reader.nextLine();
		return input;
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = reader.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			writer.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		writer.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			writer.println(optionNum + ") " + options[i]);
		}
		writer.print(System.lineSeparator() + "Please choose an option >>> ");
		writer.flush();
	}
}
