package POSPD;

import java.math.*;

public class CashDrawer
{

	private BigDecimal cashAmount;
	private int position;
	
	

	public BigDecimal getCashAmount()
	{
		return this.cashAmount;
	}

	
	public void setCashAmount(BigDecimal cashAmount)
	{
		this.cashAmount = cashAmount;
	}
	
	

	public int getPosition()
	{
		return this.position;
	}

	
	public void setPosition(int position)
	{
		this.position = position;
	}

}