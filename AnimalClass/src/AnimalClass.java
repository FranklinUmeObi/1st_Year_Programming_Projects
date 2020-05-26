import javax.swing.JOptionPane ;
import java.util.Scanner ; 
public class AnimalClass {

	public static void main(String[] args) {
//input	
		System.out.println("To determine what class the animal is can you answer the following questions,"
				+ " \n answering true for true or false for false ");
		System.out.println("-- Is the animal cold blooded? : ");
		Scanner scan = new Scanner(System.in) ;
		Boolean coldBlood = scan.nextBoolean() ;
		
		if (coldBlood == true)
		{
			System.out.print("--Is the animal covered in scales? : ") ;
			Boolean scales = scan.nextBoolean() ;
			if (scales == true)
			{
				System.out.print("--Does the animal have fins? : ") ;
				Boolean fins = scan.nextBoolean() ;
				if (fins == true)
				{
					System.out.print("The animal has been classified as a FISH ") ;
				}
				else
				{
					System.out.print("The animal has been classified as a REPTILE ") ;
				}
			}
			else
			{
				System.out.print("The animal has been classified as an AMPHIBIAN ") ;
			}
		}
		else 
		{
			System.out.print("--Is the animal covered in feathers? : ") ;
			Boolean feathers = scan.nextBoolean() ;
			if (feathers == true)
			{
				System.out.print("The animal has been classified a BIRD ") ;
			}
			else
			{
				System.out.print("The animal has been classified as a MAMMAL ") ;
			}
		}
		
		
		
		
		
	}

}
