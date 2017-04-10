package POSPD;


import java.math.*;
import java.util.*;


public class Sale  
{

	
	private List<Payment> payments;
	
	private List<SaleLineItem> saleLineItems;
	private GregorianCalendar dateTime;
	private Boolean taxFree;
	private Session session;
     
	
	public Sale()
	{
		setDateTime(new GregorianCalendar());
		saleLineItems = new ArrayList<SaleLineItem>();
		payments = new ArrayList<Payment>();
		setTaxFree(false);
	}

	
	public Sale(Session session, String taxFree)
	{
		this();
		if (taxFree.equals("N")) setTaxFree(true); else setTaxFree(false);
		setDateTime(new GregorianCalendar());
		session.addSale(this);
		setSession(session);
	}
	
    
	public List<Payment> getPayments()
	{
		return this.payments;
	}
    
	
	public List<SaleLineItem> getSaleLineItems()
	{
		return this.saleLineItems;
	}
	
    
	public GregorianCalendar getDateTime()
	{
		return this.dateTime;
	}
	
   
	public void setDateTime(GregorianCalendar dateTime)
	{
		this.dateTime = dateTime;
	}
	
    
	public Boolean getTaxFree()
	{
		return this.taxFree;
	}
	
    
	public void setTaxFree(Boolean taxFree)
	{
		this.taxFree = taxFree;
	}
	
	
	
	public BigDecimal calcTotal()
	{
		return calcSubTotal().add(calcTax());
	}
 
	
	public BigDecimal calcSubTotal()
	{
		BigDecimal subTotal = new BigDecimal ("0");
		for (SaleLineItem sli : saleLineItems)
		{ subTotal = subTotal.add(sli.calcSubTotal());}
		return subTotal.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	
	public BigDecimal calcChange()
	{
		return calcAmtTendered().subtract(calcTotal());
	}

	
	public BigDecimal calcTax()
	{
		BigDecimal tax = new BigDecimal ("0");
		if (!getTaxFree() )
		{
			for (SaleLineItem sli : saleLineItems)
			{ tax = tax.add(sli.calcTax());}
		}
		return tax.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	
	public BigDecimal calcAmount(BigDecimal amountTendered)
	{
		BigDecimal calcAmount = calcTotal().subtract(calcTotalPayment());
		if (calcAmount.compareTo(amountTendered) > 0)
		{
			calcAmount = amountTendered;
		}
		return calcAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	
	public BigDecimal calcTotalPayment()
	{
		BigDecimal payment = new BigDecimal ("0");
		for (Payment p : payments)
		{ payment = payment.add(p.getAmount());}
		
		return payment.setScale(2,BigDecimal.ROUND_HALF_UP);
	}
	
	
	public BigDecimal calcCash()
	{
		BigDecimal cash = new BigDecimal ("0");
		for (Payment p : payments)
		{ if (p.hasCash()) cash = cash.add(p.getAmount());}
		
		return cash;
	}
	
	
	public BigDecimal calcAmtTendered()
	{
		BigDecimal amtTendered = new BigDecimal ("0");
		for (Payment p : payments)
		{ amtTendered = amtTendered.add(p.getAmtTendered());}
		
		return amtTendered.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
    
	
	public Boolean isPaymentEnough()
	{
		return (calcTotalPayment().compareTo(calcTotal()) >= 0);
	}

	
	public void addPayment(Payment payment)
	{
		getPayments().add(payment);
	}

	
	public void addSaleLineItem(SaleLineItem sli)
	{
		getSaleLineItems().add(sli);
		sli.setSale(this);
	}
	
	
	public String toString()
	{
		String slis = "";
		   for (SaleLineItem sli : getSaleLineItems()) { slis += "     "+sli.toString()+"\r\n";}
		return "Sale : SubTotal = "+calcSubTotal().toPlainString() 
				+" Tax = "+calcTax().toPlainString()
				+" Total = "+calcTotal().toPlainString()
				+" Payment = "+calcTotalPayment().toPlainString()
				+" Change = "+calcChange()+"\r\n"+slis;
	}
	
	   public int compareTo(Sale sale){
	      return getDateTime().compareTo(sale.getDateTime());
	   }

	   
	   public int compare(Sale s1, Sale s2){
	      return (int) (s1.getDateTime().getTimeInMillis()- s2.getDateTime().getTimeInMillis()) ;
	     
	   }
    
	 
	public Session getSession() {
		return session;
	}

	
	public void setSession(Session session) {
		this.session = session;
	}
	   

}