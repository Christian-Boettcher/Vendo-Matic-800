package com.techelevator.view;

import com.techelevator.ProductChoices;
import com.techelevator.items.Item;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {

	private final PrintWriter out;
	private final Scanner in;

	public Menu(InputStream input, OutputStream output)
	{
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Item getChoiceFromProductChoiceMap(ProductChoices productChoicesObject)
	{
		String userInput = in.nextLine().toUpperCase();
		if (productChoicesObject.getProductChoices().containsKey(userInput))
		{
			return productChoicesObject.getProductChoices().get(userInput);
		}
		else
		{
			System.out.println("That is not a valid input");
			return null;
		}
	}

	public Object getChoiceFromOptions(Object[] options)
	{
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	public Object getChoiceFromPurchaseOptions(Object[] options, String currentAmountMessage)
	{
		Object choice = null;
		while (choice == null) {
			displayPurchaseOptions(options, currentAmountMessage);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options)
	{
		Object choice = null;
		String userInput = in.nextLine();
		try
		{
			int selectedOption = Integer.parseInt(userInput);
			if (selectedOption > 0 && selectedOption <= options.length)
			{
				choice = options[selectedOption - 1];
			}
		}
		catch (NumberFormatException e)
		{
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null)
		{
			out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options)
	{
		out.println();
		for (int i = 0; i < options.length; i++)
		{
			int optionNum = i + 1;
			if (options[i].toString().length()>0)
			{
			out.println(optionNum + ") " + options[i]);
			}
		}
		out.print(System.lineSeparator() + "Please choose an option >>> ");
		out.flush();
	}

	private void displayPurchaseOptions(Object[] options, String currentAmountMessage)
	{
		out.println();
		for (int i = 0; i < options.length; i++)
		{
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.println(currentAmountMessage);
		out.print(System.lineSeparator() + "Please choose an option >>> ");
		out.flush();
	}
}
