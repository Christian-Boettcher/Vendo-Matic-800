package com.techelevator;

import junit.framework.TestCase;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class CurrentMoneyTest extends TestCase
{

    @Test
    public void testCalculateChange()
    {
        CurrentMoney testMoney = new CurrentMoney();
        testMoney.addMoney(7.15);
        Map<String, Integer> testChange = new HashMap();
        testChange.put("Nickels", 1);
        testChange.put("Dimes", 1);
        testChange.put("Quarters", 28);
        System.out.println(CurrentMoney.calculateChange(testMoney.getCurrentMoney()) + "\n" + testChange);
        assertEquals(testChange,CurrentMoney.calculateChange(testMoney.getCurrentMoney()));
    }
}