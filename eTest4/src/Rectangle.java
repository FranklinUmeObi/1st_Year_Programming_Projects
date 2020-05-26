
public class Rectangle extends Shape 
{

private double length ;
private double width ;

	
	
	Rectangle(String name, double length, double width)
	{
		super(name) ;
		this.length =length ;
		this.width =width ;
	}
	
	
	 public double area()
	 {
		 return width*length ;
	 }
	
	 @Override
	 public String toString()
	    {
	       return   shapeName + " of length " + length + " and of width " + width;
	    }
	
	
	
}
