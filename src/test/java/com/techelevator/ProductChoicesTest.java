package com.techelevator;

import com.techelevator.items.Candy_Item;
import com.techelevator.items.Chips_Item;
import com.techelevator.items.Drink_Item;
import com.techelevator.items.Item;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class ProductChoicesTest extends TestCase
{

    @Test
    public void testPopulateItemMap()
    {
        Map<String, Item> testChoices = new LinkedHashMap<>();
        Chips_Item chips = new Chips_Item("A1","Lays",3.05);
        Candy_Item candy = new Candy_Item("B2","Snickers",1.45);
        Drink_Item drink = new Drink_Item("C3","Pepsi",2.75);
        testChoices.put("A1",chips);
        testChoices.put("B2",candy);
        testChoices.put("C3",drink);

        ProductChoices productChoices = new ProductChoices(new File (System.getProperty("user.dir") + "/src/test/java/com/techelevator/testitemlist.csv"));


        assertEquals(testChoices.get("A1").getName(), productChoices.getProductChoices().get("A1").getName());
        assertEquals(testChoices.get("B2").getName(), productChoices.getProductChoices().get("B2").getName());
        assertEquals(testChoices.get("C3").getName(), productChoices.getProductChoices().get("C3").getName());
    }
}