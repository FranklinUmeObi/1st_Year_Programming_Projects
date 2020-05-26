import java.lang.Math ;
import java.util.Scanner ;
public class EuclideanSpace {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Please input your vector in the form (x1, x2, x3, ...) : ") ;
		scan.useDelimiter( ",") ;
		scan.useDelimiter( ")") ;
		
		if (scan.hasNextDouble())
		{
			int count = 0 ;
			while(scan.hasNext())
			{
				count++ ;
			}
			Double[] vector = new Double[count] ; 
			for(int index = 0 ; index < count ; index++)
			{
				vector[index] = scan.nextDouble() ;
			}
			
			
		}
		else
		{
			System.out.print("Invalid Input") ;
		}
	}
//	public static double determineMagnitude(double directionX, double directionY)
	{
//		double magnitude = 0 ;
//		return magnitude = Math.sqrt((directionX)*(directionX) + (directionY)*(directionY)) ;
	}
//	public static double[] normaliseVector(double directionX, double directionY)
	{
//		double normalisedX = directionX / determineMagnitude(directionX, directionY) ;
//		double normalisedY = directionY / determineMagnitude(directionX, directionY) ;
//		double[] vector = {directionX, directionY} ;
//		return vector ;
	}
//	public static double determineDotProduct(double directionX, double directionY)
	{
		
	}
//	public static double addElementsOfVector(double element1, double element2)
	{
		
	}
}
