package POSPD;

import java.math.BigDecimal;
import java.util.*;

public class Cashier
{

	private String number;
	private Person person;
	
	private ArrayList<Session> sessions;
	
	
	private String password;
	
	
	
	

	public Cashier()
	{ 
		sessions = new ArrayList<Session>();
		person = new Person();
	}
	
	
	public Cashier(String number, Person person, String password)
	{
		this();
		setNumber(number);
		setPerson(person);
		setPassword(password);
	}
	
	

	public String getNumber()
	{
		return this.number;
	}
	
	

	public void setNumber(String number)
	{
		this.number = number;
	}
	
	

	public Person getPerson()
	{
		return this.person;
	}
	
	

	public void setPerson(Person person)
	{
		this.person = person;
	}
	
	

	public ArrayList<Session> getSessions()
	{
		return this.sessions;
	}
	
	

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	
	public Boolean isAuthorized(String password)
	{
		return  getPassword().compareTo(password) == 0;
	}
	
	
	
	public Boolean isUsed()
	{
		return getSessions().size() != 0;
	}
	
	
   
	
	public int calcNumberSales(GregorianCalendar date)
	{
		int numSales= 0;
		for (Session session : getSessions())
		{
			
			if (session.getStartDateTime().get(Calendar.YEAR) == date.get(Calendar.YEAR) &&
					session.getStartDateTime().get(Calendar.DAY_OF_YEAR) == date.get(Calendar.DAY_OF_YEAR))
				{
					numSales+=session.getSales().size();
				}
		}
		return numSales;
	}
	
	
	
	public BigDecimal calcDollarSales(GregorianCalendar date)
	{
		BigDecimal dollarSales= new BigDecimal("0.00");
		for (Session session : getSessions())
		{
			
			if (session.getStartDateTime().get(Calendar.YEAR) == date.get(Calendar.YEAR) &&
					session.getStartDateTime().get(Calendar.DAY_OF_YEAR) == date.get(Calendar.DAY_OF_YEAR))
				{
				
					dollarSales = dollarSales.add(session.calcTotal());
				}
		}
		 
		return dollarSales;
	}
	
	public void addSession(Session session)
	{
		getSessions().add(session);
	}
	
	public String toString()
	{
		return getNumber()+" "+getPerson().getName();
	}
}