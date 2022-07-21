package com.techelevator;

import java.io.*;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger
{

    private static final File tempDIR = new File(System.getProperty("user.dir")+"\\logs\\");
    private static PrintWriter logWriter;

    public static void log(String message)
    {
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("d/MM/uuuu HH:mm:ss a ");
        String timeStamp = LocalDateTime.now().format(dateTimeFormat);

        if(!tempDIR.exists())
        {
            tempDIR.mkdir();
        }
        File log = new File(tempDIR+"/Log.txt");
        try
        {
            if(log.createNewFile());
        }
        catch (IOException error)
        {
            System.err.println("Log file could not be created");
        }

        if (logWriter == null)
        {
            try (PrintWriter logWriter = new PrintWriter (new FileOutputStream(log, true)))
            {
                logWriter.println(">" + timeStamp + message + "\n");
            }
            catch (FileNotFoundException error)
            {
                System.err.println("Log file could not be found");
            }
        }
        else logWriter.println(">" + timeStamp + message + "\n");
    }

    public static File generateSalesReport (ProductChoices productChoices)
    {
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("d-MMM-uuuu HH-mma");
        String timeStamp = LocalDateTime.now().format(dateTimeFormat);
        NumberFormat currency = NumberFormat.getCurrencyInstance();  //format currency
        if(!tempDIR.exists())
        {
            tempDIR.mkdir();
        }
        File salesReport = new File(tempDIR +"/"+ timeStamp +"_salesreport.txt");
        try
        {
            if(salesReport.createNewFile());
        }
        catch (IOException error)
        {
            System.err.println("SalesReport file could not be created");
        }

        if (logWriter == null)
        {
            try (PrintWriter reportWriter = new PrintWriter (new FileOutputStream(salesReport)))
            {
                double totalSales = 0.00;
                for (String f : productChoices.getProductChoices().keySet())
                {
                    String productName = productChoices.getProductChoices().get(f).getName() + "|";
                    int productInventory = ProductChoices.DEFAULT_STARTING_INVENTORY - productChoices.getProductChoices().get(f).getInventory();
                    totalSales+= productInventory*productChoices.getProductChoices().get(f).getPrice();
                    reportWriter.println(productName + productInventory);
                }
                reportWriter.println("\n####################################");
                reportWriter.println("        TOTAL SALES: "+currency.format(totalSales));
                reportWriter.println("####################################\n");
                reportWriter.flush();
                return salesReport;
            }
            catch (FileNotFoundException error)
            {
                System.err.println("SalesReport file could not be found");
            }
        }
        else
        {
            for (String f : productChoices.getProductChoices().keySet())
            {
                String productName = productChoices.getProductChoices().get(f).getName() + "|";
                int productInventory = productChoices.getProductChoices().get(f).getInventory();
                logWriter.println(productName + productInventory);
            }
            return salesReport;
        }
        return salesReport;
    }
}
