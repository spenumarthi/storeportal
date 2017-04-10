package POSDM;


import java.util.Map.Entry;
import POSPD.*;

public class Main {
	public static Store Store;
	
		
	public static void main()
	{
		
		l("Cashiers Data");
		
		for (Entry<String, Cashier> entry : Store.getCashiers().entrySet()) 
		{
	        l(entry.getValue().getPerson().getName());
	        
		}
		l("																			");
		l("-------------------------------------------------------------------------");
		
		l("Registers Data");
		
		for (Entry<String, Register> entry : Store.getRegisters().entrySet()) 
		{
	        l(entry.getValue().getNumber());
	        
		}
		l("																			");
		l("-------------------------------------------------------------------------");
		l("Items Data");
		
		for (Entry<String, Item> entry : Store.getItems().entrySet()) 
		{
	        l(entry.getValue().toString());
		}
		l("																			");
		l("-------------------------------------------------------------------------");
		l("Sessions Data");
		
		for (Session session : Store.getSessions())
	
		{
	        l(session.toString());
		}
		
	}
	

	public static void main(String[] args) 
	{
		Store = new Store();
		Store.openStore();
		main();
	}
	public static void l(Object s){
		System.out.println(s);
	}
}


