/* SELF ASSESSMENT

Harness Class: Member variables (8/8 marks)
All my data members are declared, private and the ones that don't change are marked as private. I also have a constant for the maximum number of uses of a harness.
Comment: All my data members are declared, private and the ones that don't change are marked as private. I also have a constant for the maximum number of uses of a harness.

Harness Class: Harness constructor 1 & constructor 2 (6/6 marks)
I initialise all the variables using the parameters given and set the other members to reasonable default values.
Comment: I initialised all the variables using the parameters given and set the other members to reasonable default values.

Harness Class: checkHarness method (5/5 marks)
My method takes an instructor's name as a parameter, and if the harness is not on loan sets the instructor member variable to the given parameter value (assuming the instructor's name is not null/empty). It also resets the number of times the harness was used.
Comment: My method takes an instructor's name as a parameter, and if the harness is not on loan sets the instructor member variable to the given parameter value

Harness Class: isHarnessOnLoan method (2/2 marks)
My method has no parameters and returns the value of the loan status variable.
Comment: My method has no parameters and returns the value of the loan status variable

Harness Class: canHarnessBeLoaned method (4/4 marks)
My method has no parameters and returns true if the harness is not on loan and if the number of times it was used is less than the maximum allowed number of times.
Comment: My method has no parameters and returns true if the harness is not on loan and if the number of times it was used is less than the maximum allowed number of times.

Harness Class: loanHarness method (6/6 marks)
My method has a member name as a parameter and it checks if harness can be loaned by using the canHarnessBeLoaned method. If true, it sets the club member value to the parameter value, sets the on loan status to true and increments the number of times used variable.
Comment: My method has a member name as a parameter and it checks if harness can be loaned by using the canHarnessBeLoaned method
 
Harness Class: returnHarness method (5/5 marks)
My method has no parameters, checks if the harness is on loan, and if so, changes its on-loan status to false, and resets the club member value.
Comment: My method has no parameters, checks if the harness is on loan, and if so, changes its on-loan status to false, and resets the club member value.

Harness Class: toString method (3/3 marks)
My method returns a String representation of all the member variables.
Comment: My method returns a String representation of all the member variables.

HarnessRecords Class: member variables (3/3 marks)
I declare the member variable as a private collection of Harnesses 
Comment: I declare the member variable as a private collection of Harnesses

HarnessRecords Class: HarnessRecords constructor 1 & 2 (7/9 marks)
In the first constructor, I set the member variable to null [1 mark]. In the second constructor, I use the set of characteristics in the list to create Harness objects and add them to the collection. 
Comment: My first constructor is implemented correctly, my second one is a bit sketchy.

HarnessRecords Class: isEmpty method (1/1 marks)
I return true if the collection is null/empty and, false otherwise.
Comment: I return true if the collection is null/empty and, false otherwise.

HarnessRecords Class: addHarness method (5/5 marks)
My method takes a Harness object as a parameter and adds the harness to the collection.
Comment: My method takes a Harness object as a parameter and adds the harness to the collection.

HarnessRecords Class: findHarness method (6/6 marks)
My method takes a make and model number as parameters. It checks if a harness with such properties exists and if it does it returns harness object, otherwise returns null.
Comment: My method takes a make and model number as parameters. It checks if a harness with such properties exists and if it does it returns harness object, otherwise returns null.

HarnessRecords Class: checkHarness method (6/6 marks)
must take instructor name, make and model number as parameters and return a Harness. If a harness with the make and model number exists by using the findHarness method and is not on loan, the Harness method checkHarness is called with the instructor name as a parameter and the updated Harness object is returned. If the harness is not available returns null.
Comment: the method checks the harness, changes its characteristics and returns the harness

HarnessRecords Class: loanHarness method (7/7 marks)
My method takes a club member name as a parameter and looks for an available harness by calling the method canHarnessBeLoaned be loaned. If an available harness is found it is loaned by using the Harness method loanHarness with the club member as a parameter, returning the harness. If there's no available harness null is returned.
Comment: the method loans the harness, changes its characteristics and returns the harness

HarnessRecords Class: returnHarness method (7/7 marks)
My method takes a make and model number as parameters. It checks if a harness with those properties exists by using the findHarness method. If the found harness is not null, it returns the harness object by using Harness method returnHarness, otherwise returns null.
Comment: the method returns the harness, changes its characteristics and returns the harness

HarnessRecords Class: removeHarness method (8/8 marks)
My method takes a make and model number as parameters and check the collection for a harness with those properties and removes it. It returns the harness object if it is found, otherwise returns null.
Comment: the method removes the harness, changes its characteristics and returns the harness

GUI (Java main line) (5/5 marks)
My test class has a menu which implements at least the five points specified using the HarnessRecords class methods.
Comment: I have a pretty sleek user interface which has 7 options including the 5 specified

*/



import javax.swing.JOptionPane;
public class GUIHarness {

	public static void main(String[] args) 
	{
		HarnessRecords hRecords = new HarnessRecords() ;
		boolean finished = false ;
		do {
				Object[] possibleChoices = {"Print a list of our Harness'",
							"Add a record for a newly purchased harness", 
							"Remove a climbing harness from the club", 
							"Record the fact that a club instructor has checked the safety of a harness",
							"Loan a harness to a club member if there is an availabe harness",
							"Return a harness which is no longer in use by a club member",
							"Exit the Program"};
				
				Object selectedOption = JOptionPane.showInputDialog(null, "What would you like to do?", "Input",
				JOptionPane.INFORMATION_MESSAGE, null, possibleChoices, possibleChoices[0]);
				if(selectedOption == "Print a list of our Harness'")
				{
					System.out.println("This is the current record of harnesess'") ;
					for(int i = 0 ; i < hRecords.recordsSize() ; i++)
					{
						int num = i + 1 ;
						System.out.println("Harness " + num + ") " + hRecords.getMyHarness(i).toString());
					}
				}
				else if(selectedOption == "Add a record for a newly purchased harness")
				{
					theAddOption(hRecords) ;
				}
				else if(selectedOption == "Remove a climbing harness from the club")
				{
					theRemoveOption(hRecords) ;
				}
				else if(selectedOption == "Record the fact that a club instructor has checked the safety of a harness")
				{
					theCheckOption(hRecords) ;
				}
				else if(selectedOption == "Loan a harness to a club member if there is an availabe harness")
				{
					theLoanOption(hRecords) ;
				}
				else if(selectedOption == "Return a harness which is no longer in use by a club member")
				{
					theReturnOption(hRecords) ;
				}
				else if(selectedOption == "Exit the Program")
				{
					finished = true ;
				}
				
		}while(!finished) ;
	}
	
	public static void theAddOption(HarnessRecords hRecords)
	{
		try 
		{
			String inputMake = JOptionPane.showInputDialog("What is the make of this Harness? eg.(PETZL)");
			String inputModel = JOptionPane.showInputDialog("What is the model of this Harness? eg.(4576)");
			String inputInstructor = JOptionPane.showInputDialog("Which Instructor Checked the safety of this Harness?");
			int model = Integer.parseInt(inputModel) ;
			Harness harnessToAdd = new Harness(inputMake, model, inputInstructor) ;
			hRecords.addHarness(harnessToAdd) ;
		}
		catch(Exception invalid)
			{
				System.out.print("Those were not valid inputs") ;
			}
	}
	
	public static void theRemoveOption(HarnessRecords hRecords)
	{
		if(!hRecords.isEmpty())
		{
			try
			{
				String inputMake = JOptionPane.showInputDialog("What is the make of this Harness? eg.(PETZL)");
				String inputModel = JOptionPane.showInputDialog("What is the model of this Harness? eg.(4576)");
				int model = Integer.parseInt(inputModel) ;
				Harness test = hRecords.removeHarness(inputMake, model) ;
				if (test == null) 
				{
					System.out.println("The Harness you are looking for does not exist");
				}
				else
				{
					System.out.println("The following harness was removed - " + test.toString());
				}
				
			}
			catch(Exception invalid)
				{
					System.out.print("Those were not valid inputs") ;
				}
		}
		else System.out.println("There are no harnesses to remove");
	}

	public static void theCheckOption(HarnessRecords hRecords)
	{
		if(!hRecords.isEmpty())
		{
			try
			{
				String inputMake = JOptionPane.showInputDialog("What is the make of this Harness you want to check? eg.(PETZL)");
				String inputModel = JOptionPane.showInputDialog("What is the model of this Harness? eg.(4576)");
				String inputInstructor = JOptionPane.showInputDialog("Which Instructor is checking the safety of this Harness?");
				int model = Integer.parseInt(inputModel) ;
				Harness test = hRecords.checkHarness(inputMake, model, inputInstructor) ;
				if (test == null) System.out.println("The Harness you are looking for does not exist");
			}
			catch(Exception invalid)
				{
					System.out.print("Those were not valid inputs") ;
				}
		}
		else System.out.println("There are no harnesses to check");
	}
	
	public static void theLoanOption(HarnessRecords hRecords)
	{
		if(!hRecords.isEmpty())
		{
			try
			{
				String inputMember = JOptionPane.showInputDialog("What is the name of the member");
				Harness test = hRecords.loanHarness(inputMember) ;
				if (test == null) System.out.println("The Harness you are looking for does not exist");
				System.out.println("The following harness was loaned - " + test.toString());
			}
			catch(Exception invalid)
				{
					System.out.print("Those were not valid inputs") ;
				}
		}
		else System.out.println("There are no harnesses to loan");
	}
	
	public static void theReturnOption(HarnessRecords hRecords)
	{
		if(!hRecords.isEmpty())
		{
			try
			{
				String inputMake = JOptionPane.showInputDialog("What is the make of this Harness? eg.(PETZL)");
				String inputModel = JOptionPane.showInputDialog("What is the model of this Harness? eg.(4576)");
				int model = Integer.parseInt(inputModel) ;
				Harness test = hRecords.returnHarness(inputMake, model) ;
				if (test == null) System.out.println("The Harness you are looking for does not exist");
			}
			catch(Exception invalid)
				{
					System.out.print("Those were not valid inputs") ;
				}
		}
		else System.out.println("There are no harnesses to return");
	}
	
	
}
