package POSPD;

public class Person
{

	private String name;
	private String address;
	private String phone;
	private String ssn;
	private Cashier cashier;
	
	
	public Person()
	{
	}

	
	public Person(String name, String address, String phone,String ssn)
	{
		setName(name);
		setAddress(address);
		setPhone(phone);
		setSSN(ssn);
	}

    
	
	public String getName()
	{
		return this.name;
	}
    
	
	public void setName(String name)
	{
		this.name = name;
	}
    
	
	public String getAddress()
	{
		return this.address;
	}
	
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	
	
	public String getPhone()
	{
		return this.phone;
	}
    
	
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
    
	
	public String getSSN()
	{
		return this.ssn;
	}
    
	
	public void setSSN(String ssn)
	{
		this.ssn = ssn;
	}
    
	
	public Cashier getCashier()
	{
		return this.cashier;
	}
    
	
	public void setCashier(Cashier cashier)
	{
		this.cashier = cashier;
	}
	
}