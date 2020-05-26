//import java.util.Collections;
import java.util.ArrayList;
import java.util.Date;

public class HRDepartment 
{
	ArrayList<Employee> employeeList = new ArrayList<Employee>() ;
	
	public static void main(String[] args) 
	{

		
		
		
		
	
	}
	
	public void addEmployee(int employeeId, String name, int role)
	{
		Employee newEmployee = new Employee(employeeId, name, role) ;
		employeeList.add(newEmployee) ;
	}
	
	public void printAllEmployees()
	{
		for (int i = 0; i < employeeList.size(); i++) 
		{
			employeeList.get(i).toString();
		}
	}
	
	public Employee findEmployee(int employeeID)
	{
		int rightID = -1;
		for (int i = 0; i < employeeList.size(); i++) 
		{
			int id = employeeList.get(i).getEmployeeId();
			if (employeeID == id) rightID = i ;
		}
		return employeeList.get(rightID) ;
	}
	
	public boolean recordEmployeeAppraisal(int id, Date appraisalDate, int score)
	{
		return true ;
	}
	
	public boolean promoteEmployee(int employeeID)
	{
		return true ;
	}
	

}
