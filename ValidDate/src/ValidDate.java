import java.util.Scanner ;
public class ValidDate {

	public static final int DAYS_IN_FEBRUARY = 28 ;
	public static final int LEAPYEAR_DAYS_IN_FEBRUARY = 29 ;
	public static final int MAX_DAYS = 31 ;
	public static final int OTHER_DAYS = 30 ;
	public static void main(String[] args) {

		System.out.print("Please enter the date in the format  <day month year> in digit form :") ;
		Scanner scan = new Scanner(System.in) ;
		int day = scan.nextInt() ;
		int month = scan.nextInt() ;
		int year = scan.nextInt() ;
		scan.close() ;
			
		if(validDate(day, month, year))
		{
			System.out.print("That date is valid");
		}
		else
		{
			System.out.print("That date is not valid");
		}
		
		
		
	}

	
	
	
	public static boolean validDate(int day, int month, int year) 
	{
		
		return true;
	}
	
	public static boolean isLeapYear(int year) 
	{
		return(year % 400 == 0 || year % 4 == 0 && year % 100 != 0) ;
	}
	
	public static int daysInMonth(int month, int year) 
	{
		int dayCount = 0 ;
		switch(month)
		{
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
		{
			dayCount = MAX_DAYS ;
			break ;
		}
		case 4:
		case 6:
		case 9:
		case 11:
		{
			dayCount = OTHER_DAYS ;
			break ;
		}
		case 2:
		{
			if (isLeapYear(year))
			{
				dayCount = LEAPYEAR_DAYS_IN_FEBRUARY ;
			}
			else
			{
				dayCount = DAYS_IN_FEBRUARY ;
			}
		}
			
		}
		return dayCount ;
	}

}
