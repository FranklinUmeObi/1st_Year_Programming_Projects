
public class Cylinder extends Shape 
{

	private double height ;
	private double radius ;

		
		
		Cylinder(String name, double radius, double height)
		{
			super(name) ;
			this.height =height ;
			this.radius =radius ;
		}
		
		
		 public double area()
		 {
			 return Math.PI*radius*radius*height ;
		 }
		
	
		 @Override
		 public String toString()
		    {
		       return  shapeName + " of radius " + radius +  " and of height " + height;
		    }
	
	
	
	
	
	
}
