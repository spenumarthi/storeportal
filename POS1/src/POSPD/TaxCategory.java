package POSPD;

import java.math.*;
import java.util.*;

public class TaxCategory
{

	private String category;
	private Calendar effectiveDate;
	private BigDecimal taxRate;
 
  
	public TaxCategory()
	{
		setTaxRate(new BigDecimal("0.00"));
	}

	
	
	public TaxCategory(String category, String effectiveDate, String taxRate)
	{
		setCategory(category);
		setTaxRate(new BigDecimal (taxRate));
		String[] ed;
		ed = effectiveDate.split("/");
		setEffectiveDate(new GregorianCalendar(Integer.parseInt(ed[2])+2000,Integer.parseInt(ed[0])-1,Integer.parseInt(ed[1])));

	}

	
	
	public String getCategory()
	{
		return this.category;
	}

	
	public void setCategory(String category)
	{
		this.category = category;
	}

	
	public Calendar getEffectiveDate()
	{
		return this.effectiveDate;
	}

	
	public void setEffectiveDate(Calendar effectiveDate)
	{
		this.effectiveDate = effectiveDate;
	}
	
	
	public void setEffectiveDate(String effectiveDate)
	{
		String[] ed;
		ed = effectiveDate.split("/");
		setEffectiveDate(new GregorianCalendar(Integer.parseInt(ed[2]),Integer.parseInt(ed[0])-1,Integer.parseInt(ed[1])));			
	}
	
	
	public void isEffective(Calendar date)
	{
		// TODO - implement TaxCategory.isEffective
		throw new UnsupportedOperationException();
	}

	
	public BigDecimal getTaxRate() {
		return taxRate;
	}
	
    
	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}
	
	
	public String toString()
	{
		return getCategory();
	}

}