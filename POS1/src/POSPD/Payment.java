package POSPD;


import java.math.*;

public abstract class  Payment
{

	private BigDecimal amount;
	
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
	
	public BigDecimal getAmtTendered()
	{ return getAmount();}

	
	public boolean hasCash()
	{
		return true;
	}
}