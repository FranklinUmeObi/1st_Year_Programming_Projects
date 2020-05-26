/*  SELF ASSESSMENT
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 10:  10 (no numbers used in my computations)
   2. Did I use easy-to-understand, meaningful CONSTANT names?
       Mark out of 5:  5 (constants are very self explanatory)
    3. Did I format the CONSTANT names properly (in UPPERCASE)?
       Mark out of 5:  5 (all constants are upper case)
   4. Did I use easy-to-understand meaningful variable names?
       Mark out of 10:  10 (I definitely used meaningful variable names)
   5. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 10:  10 (yes I did)
   6. Did I indent the code appropriately?
       Mark out of 10: 10 (all code is indented correctly)
   7. Did I read the input correctly from the user using (an) appropriate question(s)?
       Mark out of 10:  10 (yes an appropriate question was asked)
   8. Did I compute the answer correctly for all cases?
       Mark out of 20:  20 (yes the computation works in all cases)
   9. Did I output the correct answer in the correct format (as shown in the examples)?
       Mark out of 10:  10 (yes the output is in the same format as the example)
   10. How well did I complete this self-assessment?
       Mark out of 10:  10 (replied with just yes towards the end)
   Total Mark out of 100 (Add all the previous marks): 100
*/
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Pounds {
	public static final double OLD_PENNY_TO_NEW_POUND = .67;
	public static final double OLD_SHILLING_TO_NEW_POUND = 8.04;
	public static final double OLD_POUND_TO_NEW_POUND = 160.8;
	public static final double NEW_PENNY_TO_NEW_POUND = 0.01;

	public static void main(String[] args) {

//input
		String input = JOptionPane.showInputDialog("Enter the number of old pounds (x), "
				+ "old shillings (y) and old pennies (z) to be converted to "
				+ "new pounds in the form --> x y z : ");
		Scanner scan = new Scanner(input);
		double totalOldPounds = scan.nextDouble();
		double totalOldShillings = scan.nextDouble();
		double totalOldPennies = scan.nextDouble();
		scan.close();

//computation
		double totalNewPounds = (totalOldPounds * OLD_POUND_TO_NEW_POUND)
				+ (totalOldShillings * OLD_SHILLING_TO_NEW_POUND)
				+ (totalOldPennies * OLD_PENNY_TO_NEW_POUND);

//output
		JOptionPane.showMessageDialog(null, "This old currency has "
				+ "been converted to :" + totalNewPounds);

	}

}
