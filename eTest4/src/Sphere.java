
public class Sphere extends Shape 
{
	private double radius ;
	
	
	Sphere(String name, double radius)
	{
		super(name) ;
		this.radius = radius ;
	}
	
	
	 public double area()
	 {
		 return radius*4*Math.PI*radius ;
	 }
	
	 @Override
	 public String toString()
	    {
	       return shapeName + " of radius " + radius;
	    }
	
	
	
	
	
	
}
