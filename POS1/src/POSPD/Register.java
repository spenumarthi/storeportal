package POSPD;

public class Register
{

	private String number;
	private CashDrawer cashDrawer;
    
	
	public Register()
	{
		setCashDrawer(new CashDrawer());
	}

	
	public Register(Store store, String number)
	{
		this();
		setNumber(number);
		store.addRegister(this);
	}
	
	
	public String getNumber()
	{
		return this.number;
	}

	
	public void setNumber(String number)
	{
		this.number = number;
	}
    
	
	public CashDrawer getCashDrawer()
	{
		return this.cashDrawer;
	}
	
 
	public void setCashDrawer(CashDrawer cashDrawer)
	{
		this.cashDrawer = cashDrawer;
	}

	
	public String toString()
	{
		return getNumber();
	}

}