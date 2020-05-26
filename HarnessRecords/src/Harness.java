
public class Harness 
{
	private static final int MAX_USES = 25 ;
	private String make ;
	private int model ;
	private int numberOfUses ;
	private String lastInstructor ;
	private boolean onLoan ;
	private String memberWhoLoaned ;
	
	Harness(String theMake, String theLastInstructor, 
				String theMemberWhoLoaned, int theModel, int theNumberOfUses, 
				boolean isOnLoan)
	{
		make = theMake ;
		model = theModel ;
		numberOfUses = theNumberOfUses ;
		lastInstructor = theLastInstructor ;
		onLoan = isOnLoan ;
		memberWhoLoaned = theMemberWhoLoaned ;
	}
	
	Harness(String theMake, int theModel, String theLastInstructor)
	{
		make = theMake ;
		model = theModel ;
		numberOfUses = 0 ;
		lastInstructor = theLastInstructor ;
		onLoan = false ;
		memberWhoLoaned = "" ;	
	}
	
	void checkHarness(String name)
	{
		if(!onLoan)
		{
		this.lastInstructor = name ;
		this.numberOfUses = 0 ;
		}
	}
	
	boolean isHarnessOnLoan()
	{
		return onLoan ;
	}
	
	boolean canHarnessBeLoaned()
	{
		if(!onLoan && numberOfUses < MAX_USES) return true ;
		else return false ;
	}
	
	void loanHarness(String member)
	{
		if(canHarnessBeLoaned())
		{
			onLoan = true ;
			memberWhoLoaned = member ;
			numberOfUses++ ;
		}
	}
	
	void returnHarness()
	{
		if(onLoan)
		{
			onLoan = false ;
			memberWhoLoaned = null ;
			
		}
	}
	
	public String toString()
	{
		String description = "Description of Harness : " + this.make + " " 
					+ Integer.toString(this.model) + "\nNumber of uses since last check : " 
					+ Integer.toString(this.numberOfUses) + " Checked by : " 
					+ this.lastInstructor + "\n";
		if(onLoan) description += "Is currently on loan to " + this.memberWhoLoaned ;
		else description += "Currently not on loan\n";
		return description ;
	}
	
	String getMake()
	{
		return make ;
	}
	int getModel()
	{
		return model ;
	}
	int getUses()
	{
		return numberOfUses ;
	}
	boolean getLoanStatus()
	{
		return onLoan ;
	}

}
