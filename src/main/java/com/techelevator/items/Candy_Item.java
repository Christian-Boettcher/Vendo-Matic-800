package com.techelevator.items;

import com.techelevator.ProductChoices;

public class Candy_Item implements Item
{
    private String name = "";
    private String slot = "";
    private double price = 0.00;
    private int inventory = 0;

    // Constructor
    public Candy_Item(String slot, String name, double price)
    {
        this.name = name;
        this.slot = slot;
        this.price = price;
        this.inventory = ProductChoices.DEFAULT_STARTING_INVENTORY;
    }

    //region GETTERS
    @Override
    public String getName() {return name;}
    @Override
    public double getPrice() {return price;}
    @Override
    public String getSlot() {return slot;}
    @Override
    public int getInventory() {return inventory;}
    //endregion

    @Override
    public String dispenseItem()
    {
        if (inventory != 0)
        {
            inventory--;
            return "Munch Munch, Yum!";
        }
        else return "Item is currently sold out";
    }

    //region SETTERS
    public void setName(String name) {this.name = name;}

    public void setSlot(String slot) {this.slot = slot;}

    public void setPrice(double price) {this.price = price;}

    public void setInventory(int inventory) {this.inventory = inventory;}
    //endregion
}

