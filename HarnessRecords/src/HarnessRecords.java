import java.util.ArrayList ;
public class HarnessRecords 
{
	private ArrayList<Harness> records ;
	
	HarnessRecords()
	{
		records = new ArrayList<Harness>(0) ;
	}
	
	HarnessRecords(ArrayList<Harness> z, String theMake, int theModel, String theLastInstructor)
	{
		Harness harnessToAdd = new Harness(theMake, theModel, theLastInstructor) ;
		addHarness(harnessToAdd) ;
	}
	
	boolean isEmpty()
	{
		return records.isEmpty() ;
	}
	
	void addHarness(Harness x)
	{
		records.add(x) ;
	}
	
	Harness findHarness(String theMake, int theModel)
	{
		int rightIndex = -1 ;
		for(int i = 0 ; i < records.size() ; i++)
		{
			records.get(i).toString();
			if(records.get(i).getMake().equals(theMake) && records.get(i).getModel() == theModel) rightIndex = i ;
		}
		if (rightIndex != -1) return records.get(rightIndex) ;
		else return null ;
	}
	
	Harness checkHarness(String theMake, int theModel, String theLastInstructor)
	{
		Harness z = findHarness(theMake, theModel) ;
		records.remove(z) ;
		int preCheck = z.getUses() ; 
		z.checkHarness(theLastInstructor);
		int postCheck = z.getUses() ;
		if(preCheck != postCheck || preCheck == 0) 
			{
			records.add(z) ;
			return z ;
			}
		else return null ;
	}
	
	Harness loanHarness(String theMember)
	{
		int rightIndex = -1 ;
		for(int i = 0 ; i <= records.size() ; i++)
		{
			if(records.get(i).getLoanStatus() == false )
			{
				rightIndex = i ;
				break ;
			}
			
		}
		if(rightIndex != -1)
		{
		Harness w = records.get(rightIndex);
		records.remove(rightIndex) ;
		w.loanHarness(theMember);
		records.add(w) ;
		return w ;
		}
		else return null ;
		
	}
	
	Harness returnHarness(String theMake, int theModel)
	{
		Harness x = findHarness(theMake, theModel) ;
		records.remove(x) ;
		x.returnHarness();
		records.add(x);
		if(x != null) return x ;
		else return null ;
		
	}
	
	Harness removeHarness(String theMake, int theModel)
	{
		Harness x = findHarness(theMake, theModel) ;
		if (records.remove(x)) return x ;
		else return null ;
	}

	int recordsSize()
	{
		return records.size();
	}

	Harness getMyHarness(int index)
	{
		return records.get(index);
	}


}
