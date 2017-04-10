package POSPD;

import java.math.*;
import java.util.*;

public class Price implements Comparator<Price>, Comparable<Price>
{

	private BigDecimal price;
	private Calendar effectiveDate;
	private Item item;
	
	
	public Price()
	{

	}

	
	public Price(Item item, String price, String effectiveDate)
	{
		setItem(item);
		setPrice(new BigDecimal(price));
		String[] ed;
		ed = effectiveDate.split("/");
		setEffectiveDate(new GregorianCalendar(Integer.parseInt(ed[2])+2000,Integer.parseInt(ed[0])-1,Integer.parseInt(ed[1])));

	}
	
   
	public BigDecimal getPrice()
	{
		return this.price;
	}
	 
   
	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}
	
	
	public Calendar getEffectiveDate() {
		return effectiveDate;
	}
    
	
	public void setEffectiveDate(Calendar effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	
   
	public Item getItem() {
		return item;
	}
	
   
	public void setItem(Item item) {
		this.item = item;
	}
	
	
	public boolean isInEffect(GregorianCalendar date)
	
	{
		if (getEffectiveDate().compareTo(date) <= 0) return true; else return false;
	}
	
	
	   public int compareTo(Price price){
	      return getEffectiveDate().compareTo(price.getEffectiveDate());
	   }
      
	   public int compare(Price p1, Price p2){
	      return (int) (p1.getEffectiveDate().getTimeInMillis()- p2.getEffectiveDate().getTimeInMillis()) ;
	     
	   }
	   
	  
	   public String toString()
	   {
		   return getPrice().toPlainString()+" " +getEffectiveDate().getTime().toString();
	   }
	
}