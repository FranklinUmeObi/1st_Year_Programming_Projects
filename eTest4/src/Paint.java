
public class Paint 
{
	double coverage ;
	
	Paint(double coverage)
	{
		this.coverage = coverage ;
	}
	
	
	public double amount(Shape aShape)
	{
		double amount = aShape.area() / coverage ;
		String x = "Computing amount for " + aShape.toString() +"\nAmount of paint Required is :" + amount ;
		System.out.println(x);
		return amount ;
	}
	
	
	
	
	
	
	
	
	
	
}
