package POSDM;

import POSPD.*;

import java.io.*;

public class MainData {


public static void load(Store store)
{
	
	String fileName ="StoreData_S2017.csv";
	String line = null;
	String[] result;
	String dataType; 
	Session currentSession = null;
	Sale currentSale = null;
	FileReader fr = null;
	BufferedReader br = null;
    try {
       
         fr = new FileReader("StoreData_S2017.csv");
         br = new BufferedReader(fr);
        
        while((line = br.readLine()) != null) 
        {
	        	result = line.split(",");
	        	dataType = result[0];
	        	
	        	if (dataType.equals("Store"))
	        	{
	        		store.setName(result[1]);
	        	}
	        	else if (dataType.equals("Cashier"))
	        	{
	        	
	        		Person storePerson = new Person(result[2], result[3], result[4], result[5]);
	        		Cashier storeCashier = new Cashier(result[1],storePerson,result[9]);
	        		store.addCashier(storeCashier);
	        				
	        	}
	        	else if (dataType.equals("TaxCategory"))
	        		
	        	{
	        		TaxCategory storeTaxCategory = new TaxCategory(result[1],result[3],result[2]);
	        		store.addTaxCategory(storeTaxCategory);
	        	}
	        	else if (dataType.equals("Item"))
	        	{
	        		Item storeItem = new Item(store,result[1],result[3], result[4]);
	        		Price itemPrice = new Price(storeItem, result[5], result[6]);
	        		storeItem.addPrice(itemPrice);
	        		
	        	}
	        	else if (dataType.equals("Register"))
	        		
	        	{
	        		new Register(store,result[1]);
	        		
	        	}
	        	else if (dataType.equals("Session"))
	        		
	        	{
	        		currentSession = new Session(store,result[1],result[2]);
	        	}
	        	else if (dataType.equals("Sale"))
	        		
	        	{
	        		currentSale = new Sale(currentSession,result[1]);
	        	}
	        	else if (dataType.equals("SaleLineItem"))
	        		
	        	{
	        		new SaleLineItem(store, currentSale,result[1],result[2]);

	        	}
	        	else if (dataType.equals("Payment"))
	        		
	        	{
	        		if (result[1].equals("Cash") )
    				{
	        			new Cash(currentSale,result[2],result[3]);
    				}
	        		
	        	}
        }                
    }
    catch(FileNotFoundException ex) 
    {
        System.out.println("Unable to open file" +"\t" + fileName);                
    }
    catch(IOException ex) {
        System.out.println("Unable to read the file" + "\t"+ fileName);   	
	
	}
    
    finally
    {
    	try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}


}


