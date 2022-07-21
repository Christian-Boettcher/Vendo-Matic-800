package com.techelevator.items;

public interface Item
{
    String getName();
    double  getPrice();
    String getSlot();
    int getInventory();
    String dispenseItem();
}