package POSPD;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TreeMap;
import java.util.TreeSet;

public class Item
{

	private String number;
	private String description;
	private ArrayList<SaleLineItem> saleLineItems;
	private TreeSet<Price> prices;
	private TaxCategory taxCategory;
	
	
	public Item()
	{
		saleLineItems = new ArrayList<SaleLineItem>();
		prices = new TreeSet<Price>();
	}

	
	public Item(Store store, String number, String description, String taxCatagory)
	{
		this();
		setNumber(number);
		setDescription(description);
		setTaxCategory(store.findTaxCategoryForCategory(taxCatagory));
		store.addItem(this);
	}
	
	

	public String getNumber()
	{
		return this.number;
	}
	
	

	public void setNumber(String number)
	{
		this.number = number;
	}
	


	public String getDescription()
	{
		return this.description;
	}
	


	public void setDescription(String description)
	{
		this.description = description;
	}
	

	public ArrayList<SaleLineItem> getSaleLineItems()
	{
		return this.saleLineItems;
	}
	
	public TreeSet<Price> getPrices()
	{
		return this.prices;
	}

	
	public TaxCategory getTaxCategory()
	{
		return this.taxCategory;
	}
	

	public void setTaxCategory(TaxCategory taxCategory)
	{
		this.taxCategory = taxCategory;
	}
	
	
	public void addSaleLineItem (SaleLineItem sli)
	{
		if (sli != null)
		{
			getSaleLineItems().add(sli);
		}
	}
	
	
	public void addPrice (Price price)
	{
		if (price != null)
		{
			getPrices().add(price);
		}
	}
	
	public void removePrice (Price price)
	{
		if (price != null)
		{
			getPrices().remove(price);
		}
	}
	
	public BigDecimal getPriceForDate(GregorianCalendar date)
	{
		
		Price currentPrice = null;
		for (Price p : prices)
		{ 
			if (p.isInEffect(date))
			{ 
				currentPrice = p;
			}
		}
		if (currentPrice == null) return new BigDecimal("0"); 
				else return currentPrice.getPrice();
	}


	public BigDecimal getTaxRateForDate(GregorianCalendar date)
	{
		return getTaxCategory().getTaxRate();
	}
	
	
	public BigDecimal calcTotal(int quantity, GregorianCalendar date)
	{
		BigDecimal total;

		total = getPriceForDate(date).multiply(new BigDecimal(quantity));
		return(total);
	}
	
	
	public int calcItemSoldCount(GregorianCalendar date)
	{
		int count =0;
	
		for (SaleLineItem sli : getSaleLineItems())
		{
			
			if (sli.getSale().getDateTime().get(Calendar.YEAR) == date.get(Calendar.YEAR) &&
			sli.getSale().getDateTime().get(Calendar.DAY_OF_YEAR) == date.get(Calendar.DAY_OF_YEAR))
			{
				count+= sli.getQuantity();
			}
		}
		return count;
	}
	
	
	public boolean isUsed()
	{
		return getSaleLineItems().size() == 0;
	}

	
	public String toString()
	{
		return getNumber()+" "
				+getDescription()+" "
				+getPriceForDate(new GregorianCalendar()).toPlainString()+" "
				+getTaxCategory().getTaxRate().toPlainString();
				
	}
	
}