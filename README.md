## Vending Machine Software

### Application Overview

1. The vending machine dispenses beverages, candy, chips, and gum.
   - Each vending machine item has a Name and a Price.
2. A main menu displays when the software runs, presenting the following options:
    > ```
    > (1) Display Vending Machine Items
    > (2) Purchase
    > (3) Exit
    > ```
3. The vending machine inventory is stocked via an input file when the vending machine
starts.
4. The vending machine is automatically restocked each time the application runs.
5. When the customer selects "(1) Display Vending Machine Items", they're presented
with a list of all items in the vending machine with its quantity remaining:
    - Each vending machine product has a slot identifier and a purchase price.
    - Each slot in the vending machine has enough room for 5 of that product.
    - Every product is initially stocked to the maximum amount.
    - A product that has run out must indicate that it is SOLD OUT.
6. When the customer selects "(2) Purchase", they are guided through the purchasing
process menu:
    >```
    >(1) Feed Money
    >(2) Select Product
    >(3) Finish Transaction
    >
    > Current Money Provided: $2.00
    >```
7. The purchase process flow is as follows:
    1. Selecting "(1) Feed Money" allows the customer to repeatedly feed money into the
    machine in valid, whole dollar amounts—for example, $1, $2, $5, or $10.
        - The "Current Money Provided" indicates how much money the customer
        has fed into the machine.
    2. Selecting "(2) Select Product" allows the customer to select a product to
    purchase.
        - Show the list of products available and allow the customer to enter
        a code to select an item.
        - If the product code does not exist, the customer is informed and returned
        to the Purchase menu.
        - If a product is sold out, the customer is informed and returned to the
        Purchase menu.
        - If a valid product is selected, it is dispensed to the customer.
        - Dispensing an item prints the item name, cost, and the money
        remaining. Dispensing also returns a message:
          - All chip items print "Crunch Crunch, Yum!"
          - All candy items print "Munch Munch, Yum!"
          - All drink items print "Glug Glug, Yum!"
          - All gum items print "Chew Chew, Yum!"
        - After the product is dispensed, the machine updates its balance
        accordingly and return the customer to the Purchase menu.
    3. Selecting "(3) Finish Transaction" allows the customer to complete the
    transaction and receive any remaining change.
        - The customer's money is returned using nickels, dimes, and quarters
        (using the smallest amount of coins possible).
        - The machine's current balance is updated to $0 remaining.
    4. After completing their purchase, the user is returned to the "Main" menu to
    continue using the vending machine.
8. All purchases are audited to prevent theft from the vending machine:
   - Each purchase generates a line in a file called `Log.txt`.
   - The audit entry is in the format:
        >```
        > 01/01/2016 12:00:00 PM FEED MONEY: $5.00 $5.00
         >01/01/2016 12:00:15 PM FEED MONEY: $5.00 $10.00
         >01/01/2016 12:00:20 PM Crunchie B4 $10.00 $8.50
         >01/01/2016 12:01:25 PM Cowtales B2 $8.50 $7.50
         >01/01/2016 12:01:35 PM GIVE CHANGE: $7.50 $0.00
         >```
9. Sales Report
    - Provides a "Hidden" menu option on the main menu ("4") that writes to a sales
    report that shows the total sales since the machine was started. The name of the
    file includes the date and time so each sales report is uniquely named.
    - An example of the output format is provided below.
10. Unit tests provided to demonstrate that code works correctly.
___
### Vending Machine Data File
The input file that stocks the vending machine products is a pipe `|` delimited file. Each line is a separate product in the file and follows the below format:

| Column Name   | Description |
----------------|-------------|
| Slot Location | The slot location in the vending machine where the product is set. |
| Product Name  | The display name of the vending machine product.                   |
| Price         | The purchase price for the product.                                |
| Type          | The product type for this row.                                     |

For example:

```
A1|Potato Crisps|3.05|Chip
B1|Moonpie|1.80|Candy
B2|Cowtales|1.50|Candy
C1|Cola|1.25|Drink
```

An input file has been provided: `vendingmachine.csv`.

 ---
### Sales Report
The output sales report file is also pipe-delimited for consistency. Each line is a separate product with the number of sales for the applicable product. At the end of the report is a blank line followed by the **TOTAL SALES** dollar amount indicating the gross sales from the vending machine.

**Example Output**

>```
>Potato Crisps|10
>Stackers|3
>Grain Waves|0
>Cloud Popcorn|50
>Moonpie|23
>Cowtales|2
>Wonka Bar|1
>Crunchie|3
>Skor|4
>Cola|8
>Dr. Salt|9
>Mountain Melter|12
>Heavy|11
>Diet Cola|6
>U-Chews|4
>Little League Chew|2
>Chiclets|0
>Triplemint|0
>```
