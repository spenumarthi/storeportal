package POSPD;

import java.math.*;

public class Cash extends Payment
{

	private BigDecimal amtTendered;
	
	public Cash()
	{
		
	}
	
	public Cash(Sale sale, String amount, String amtTendered)
	{
		this();
		setAmount(new BigDecimal(amount));
		setAmtTendered(new BigDecimal(amtTendered));
		sale.addPayment(this);
	}
	
	public BigDecimal getAmtTendered()
	{
		return this.amtTendered;
	}

	public void setAmtTendered(BigDecimal amtTendered)
	{
		this.amtTendered = amtTendered;
	}

	

	

}