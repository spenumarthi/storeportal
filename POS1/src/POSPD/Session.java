package POSPD;

import java.math.BigDecimal;
import java.util.*;

public class Session implements Comparator<Session>, Comparable<Session>
{

	private Cashier cashier;
	private Register register;
	private ArrayList<Sale> sales;
	private Calendar startDateTime;
	private Calendar endDateTime;
    
	
	public Session()
	{
		sales = new ArrayList<Sale>();
		startDateTime = new GregorianCalendar();
	}
	
	
	public Session(Store store, String cashier, String register)
	{
		this();
		Cashier c = store.findCashierForNumber(cashier);
		setCashier(c);
		setRegister(store.findRegisterForNumber(register));
		
		store.addSession(this);
		c.addSession(this);
		
	}
	
    
	
	public Session(Store store, Cashier cashier, Register register)
	{
		this();
		setCashier(cashier);
		setRegister(register);
		store.addSession(this);
		cashier.addSession(this);
		
	}
	
	
	
	public Cashier getCashier()
	{
		return this.cashier;
	}
	
   
	public void setCashier(Cashier cashier)
	{
		this.cashier = cashier;
	}
    
	
	public Register getRegister()
	{
		return this.register;
	}
    
	
	public void setRegister(Register register)
	{
		this.register = register;
	}
    
	
	public ArrayList<Sale> getSales()
	{
		return this.sales;
	}
    
	
	public Calendar getStartDateTime()
	{
		return this.startDateTime;
	}
    
	
	public void setStartDateTime(Calendar startDateTime)
	{
		this.startDateTime = startDateTime;
	}

	
	public Calendar getEndDateTime()
	{
		return this.endDateTime;
	}
    
	
	public void setEndDateTime(Calendar endDateTime)
	{
		this.endDateTime = endDateTime;
	}

	
	public void addSale(Sale sale)
	{
		if (sale != null)
		{
			getSales().add(sale);
		}
	}
	
	
	public BigDecimal calcTotal()
	{
		BigDecimal total = new BigDecimal ("0");
		for (Sale  sale : sales)
		{ total = total.add(sale.calcTotal());}
		
		return total.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	
	public int getNumberSales()
	{
		return getSales().size();
	}
	
	
	public BigDecimal getTotalCash()
	{
		BigDecimal totalCash = new BigDecimal("0");
		for (Sale sale: getSales())
		{
			totalCash = totalCash.add(sale.calcCash());
		}
		return totalCash.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	
	public BigDecimal calcCashCountDiff(BigDecimal cashCount)
	{
		return (getRegister().getCashDrawer().getCashAmount().add(getTotalCash()).subtract(cashCount)).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	
	   public int compareTo(Session session){
	      return (getStartDateTime().compareTo(session.getStartDateTime()));
	   }

	    
	   public int compare(Session p1, Session p2){
	      return (int) (p1.getStartDateTime().getTimeInMillis()- p2.getStartDateTime().getTimeInMillis()) ;
	     
	   }
	   
	  
	   public String toString()
	   {
		   String sales = "";
		   for (Sale sale : getSales()) { sales += "  "+sale.toString()+"\r\n";}
		   return "Session : Cashier :"+getCashier().getPerson().getName() +" Register :"
		          +getRegister().getNumber()+" Total : "
		          +calcTotal().toPlainString() +"\r\n"+ sales;
	   }

}