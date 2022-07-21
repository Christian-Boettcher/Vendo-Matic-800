package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class CurrentMoney
{
    private double currentMoney = 0.00;
    private static final double[] COIN_VALUES = {25, 10, 5};

    //region GETTER
    public double getCurrentMoney() {return currentMoney;}
    //endregion

    public void addMoney(double addAmount)
    {
        this.currentMoney += addAmount;
    }

    public void subtractMoney (double subtractAmount)
    {
        if (subtractAmount <= currentMoney)
        {
            currentMoney-=subtractAmount;
        }
    }

    public static Map calculateChange(double currentMoney)
    {
        Map<String, Integer> change = new HashMap();
        change.put("Quarters", 0);
        change.put("Dimes", 0);
        change.put("Nickels", 0);

        double changeCounterDummy = currentMoney;
        changeCounterDummy *= 100;  //convert to cents.

        while ((int) changeCounterDummy > 0) {
            if (COIN_VALUES[0] <= (int) changeCounterDummy)
            {
                int amount = change.get("Quarters");
                change.put("Quarters", amount + 1);
                changeCounterDummy -= COIN_VALUES[0];
            }
            else if (COIN_VALUES[1] <= (int) changeCounterDummy)
            {
                int amount = change.get("Dimes");
                change.put("Dimes", amount + 1);
                changeCounterDummy -= COIN_VALUES[1];
            }
            else if (COIN_VALUES[2] <= (int) changeCounterDummy)
            {
                int amount = change.get("Nickels");
                change.put("Nickels", amount + 1);
                changeCounterDummy -= COIN_VALUES[2];
            }
            else
            {
                break;
            }
        }
        return change;
    }
}