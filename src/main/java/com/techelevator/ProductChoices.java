package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


import com.techelevator.items.*;


public class ProductChoices
{

    //LinkedHashMap saves the order, HashMap does not.
    public Map<String, Item> productChoices = new LinkedHashMap<>();

    public static int DEFAULT_STARTING_INVENTORY = 5;

    //region CONSTRUCTOR
    public ProductChoices(File file) {
        populateItemMap(file);
    }
    //endregion

    //GETTER
    public Map<String, Item> getProductChoices() {return productChoices;}

    private void populateItemMap(File file) {
        File inventory = file;
        try(Scanner fileScanner = new Scanner(inventory))
        {
            while(fileScanner.hasNextLine())
            {
                String line = fileScanner.nextLine();
                //Split the line at the |.
                String[] splitLine = line.split("\\|");
                //Get the value at index "3" to find the item type.
                String slot = splitLine[3];
                //Switch between the values.
                switch (slot)
                {
                    case "Chip":
                        Chips_Item chips = new Chips_Item(splitLine[0], splitLine[1], Double.parseDouble(splitLine[2]));
                        productChoices.put(splitLine[0], chips);
                        break;
                    case "Candy":
                        Candy_Item candy = new Candy_Item(splitLine[0], splitLine[1], Double.parseDouble(splitLine[2]));
                        productChoices.put(splitLine[0], candy);
                        break;
                    case "Drink":
                        Drink_Item drink = new Drink_Item(splitLine[0], splitLine[1], Double.parseDouble(splitLine[2]));
                        productChoices.put(splitLine[0], drink);
                        break;
                    case "Gum":
                        Gum_Item gum = new Gum_Item(splitLine[0], splitLine[1], Double.parseDouble(splitLine[2]));
                        productChoices.put(splitLine[0], gum);
                        break;
                }
            }
        }
        catch(FileNotFoundException e)
        {
            System.err.println(e.getMessage());
        }
    }
}